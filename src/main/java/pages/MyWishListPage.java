package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import components.WishListContent;
import components.WishListItem;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class MyWishListPage extends AbsBasePage{

  @Inject
  private EditWidhListPage editWidhListPage;
  @Inject
  private GiftsPage giftsPage;

  private final WishListContent wishListContent = new WishListContent($(AppiumBy.id("ru.otus.wishlist:id/wishlists")));

  private final SelenideElement main = $(AppiumBy.id("ru.otus.wishlist:id/wishlists_loading"));
  private final SelenideElement addWishButton = $(AppiumBy.id("ru.otus.wishlist:id/add_button"));

  public MyWishListPage checkOpenPage() {
    main.shouldBe(visible);
    return this;
  }

  public MyWishListPage assertNumberOfWishLists(int value){
    wishListContent
        .shouldBe(visible)
        .asserSizeEqualTo(value);
    return this;
  }

  public EditWidhListPage clickAddButton(){
    addWishButton
        .shouldBe(visible)
        .click();
    return editWidhListPage;
  }

  public MyWishListPage assertWishListTitle(int index, String expectedTitle) {
    getWishListItem(index).assertTitleEqualsTo(expectedTitle);
    return this;
  }

  public MyWishListPage assertWishListSubtitle(int index, String expectedSubtitle) {
    getWishListItem(index).assertSubtitleEqualsTo(expectedSubtitle);
    return this;
  }

  public EditWidhListPage clickEditButton(int index) {
    getWishListItem(index).clickEdit();
    return editWidhListPage;
  }

  public GiftsPage clickWishListItem(int index) {
    getWishListItem(index).clickItem();
    return giftsPage;
  }

  private WishListItem getWishListItem(int index) {
    return wishListContent.get(index).shouldBe(visible);
  }
}
