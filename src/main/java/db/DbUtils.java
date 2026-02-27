package db;

import static java.sql.DriverManager.getConnection;

import jakarta.inject.Singleton;
import lombok.SneakyThrows;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

@Singleton
public class DbUtils {

  private final String dbUrl = System.getProperty("db.url");
  private final String dbUser = System.getProperty("db.user");
  private final String dbPass = System.getProperty("db.password");

  @SneakyThrows
  public void resetWishListForUser(String login, String description) {
    try (Connection conn = getConnection(dbUrl, dbUser, dbPass)) {
      conn.setAutoCommit(false);

      String deleteGiftsSql =
            """
            DELETE FROM gifts
            WHERE wish_id IN (
                SELECT id FROM wishlists
                WHERE user_id IN (
                    SELECT id FROM users WHERE username = ?
                )
            )
            """;
      try (PreparedStatement ps = conn.prepareStatement(deleteGiftsSql)) {
        ps.setString(1, login);
        ps.executeUpdate();
      }

      String deleteSql =
            """
            DELETE FROM wishlists 
            WHERE user_id IN (
                SELECT id FROM users WHERE username = ?
            )
            """;

      try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
        ps.setString(1, login);
        ps.executeUpdate();
      }

      UUID wishlistId = java.util.UUID.randomUUID();

      String insertSql =
            """
            INSERT INTO wishlists (id, user_id, description, title)
            SELECT ?::uuid, id, ?, ?
            FROM users
            WHERE username = ?
            """;

      try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
        ps.setString(1, wishlistId.toString());
        ps.setString(2, description);
        ps.setString(3, description);
        ps.setString(4, login);
        ps.executeUpdate();
      }

      conn.commit();
    }
  }

  @SneakyThrows
  public void resetGiftForUser(String login, int price, String description) {
    try (Connection conn = getConnection(dbUrl, dbUser, dbPass)) {
      conn.setAutoCommit(false);

      String deleteSql =
            """
            DELETE FROM gifts WHERE wish_id IN (
                SELECT id FROM wishlists WHERE user_id IN (
                    SELECT id FROM users WHERE username = ?
                )
            )
            """;
      try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
        ps.setString(1, login);
        ps.executeUpdate();
      }

      String insertSql =
            """
            INSERT INTO gifts (id, name, price, wish_id)
            VALUES (
                ?::uuid, ?, ?,
                (SELECT id FROM wishlists 
                 WHERE user_id = (SELECT id FROM users WHERE username = ?) 
                 LIMIT 1)::uuid
            )
            """;

      try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
        ps.setObject(1, java.util.UUID.randomUUID());
        ps.setString(2, description);
        ps.setBigDecimal(3, new BigDecimal(price));
        ps.setString(4, login);
        ps.executeUpdate();
      }

      String touchWishlist =
            """
            UPDATE wishlists 
            SET description = ?
            WHERE user_id = (
                SELECT id FROM users WHERE username = ?
            )
            """;

      try (PreparedStatement ps = conn.prepareStatement(touchWishlist)) {
        ps.setString(1, description);
        ps.setString(2, login);
        ps.executeUpdate();
      }
      conn.commit();
    }
  }
}
