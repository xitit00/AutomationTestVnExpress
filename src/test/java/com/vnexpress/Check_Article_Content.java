package com.vnexpress;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import pageObjects.vnexpress.ArticlePageObject;
import pageObjects.vnexpress.PageGeneratorManager;
import reportConfig.ExtentTestManagerV5;


public class Check_Article_Content extends BaseTest {
	
	private WebDriver driver;
	private ArticlePageObject articlePageObject;
	
	private String nav_dymamic_class;
	private String nav_dymamic_text;
	private String paragraph_dymamic_text;
	private String caption_dymamic_text;
	private String image_dymamic_text;
	private String social_left_dymamic_title;
	private String footer_content_dymamic_class;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {

		driver = getBrowserDriver(browserName, appurl);
		articlePageObject = PageGeneratorManager.getArticlePage(driver);

	}
	
	@Test
	public void TC_01_Verify_Item_Header_Display(Method method) {
	
		ExtentTestManagerV5.startTest(method.getName(), "TC_01_Verify_Item_Header_Display");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 01: verifyVnExpressLogoDisplay");
		Assert.assertTrue(articlePageObject.isVnExpressLogoDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 02: verifyCurrentDateTimeDisplay");
		Assert.assertTrue(articlePageObject.isCurrentDateTimeDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 03: verifyVnExpressInternationalDisplay");
		Assert.assertTrue(articlePageObject.isVnExpressInternationalDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 04: verifyNewsAreaDisplay");
		Assert.assertTrue(articlePageObject.isNewsAreaDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 05: verifySearchInputDisplay");
		Assert.assertTrue(articlePageObject.isSearchInputDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 06: verifySearchButtonDisplay");
		Assert.assertTrue(articlePageObject.isSearchButtonDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 07: verifyUserItemDisplay");
		Assert.assertTrue(articlePageObject.isUserImageDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_Verify_Item_Header_Display - Step 08: verifyNotificationItemDisplay");
		Assert.assertTrue(articlePageObject.isUserNotificationDisplay());
	
	}
	
	@Test
	public void TC_02_Verify_Navigation_Bar_Item_Display(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_02_Verify_Navigation_Bar_Item_Display");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 01: verifyHomeNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isHomeNavBarDisplay());
		
		nav_dymamic_class = "thoisu";
		nav_dymamic_text = "Thời sự";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 02: verifyThoiSuNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isThoiSuNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "gocnhin";
		nav_dymamic_text = "Góc nhìn";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 03: verifyGocNhinNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isGocNhinNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "thegioi";
		nav_dymamic_text = "Thế giới";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 04: verifyTheGioiNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isTheGioiNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "video";
		nav_dymamic_text = "Video";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 05: verifyVideoNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isVideoNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "podcasts";
		nav_dymamic_text = "Podcasts";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 06: verifyPodCastsNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isPodCastsNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "kinhdoanh";
		nav_dymamic_text = "Kinh doanh";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 07: verifyKinhDoanhNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isKinhDoanhNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "khoahoc";
		nav_dymamic_text = "Khoa học";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 08: verifyKhoaHocNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isKhoaHocNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "giaitri";
		nav_dymamic_text = "Giải trí";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 09: verifyGiaiTriNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isGiaiTriNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "thethao";
		nav_dymamic_text = "Thể thao";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 10: verifyTheThaoNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isTheThaoNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "phapluat";
		nav_dymamic_text = "Pháp luật";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 11: verifyPhapLuatNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isPhapLuatNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "giaoduc";
		nav_dymamic_text = "Giáo dục";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 12: verifyGiaoDucNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isGiaoDucNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "doisong";
		nav_dymamic_text = "Đời sống";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 13: verifyDoiSongNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isDoiSongNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "dulich";
		nav_dymamic_text = "Du lịch";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 14: verifyDuLichNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isDuLichNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "xe";
		nav_dymamic_text = "Xe";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 15: verifyXeNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isXeNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
	
		nav_dymamic_class = "ykien";
		nav_dymamic_text = "Ý kiến";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 16: verifyYKienNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isYKienNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "tamsu";
		nav_dymamic_text = "Tâm sự";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 17: verifyTamSuNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isTamSuNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		nav_dymamic_class = "cuoi";
		nav_dymamic_text = "Thư giãn";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_Verify_Navigation_Bar_Item_Display - Step 18: verifyThuGianNavigateBarDisplay");
		Assert.assertTrue(articlePageObject.isThuGianNavBarDisplay(nav_dymamic_class,nav_dymamic_text));
		
		
	}
	
	@Test
	public void TC_03_Verify_Section_Page_Detail_Display(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_03_Verify_Section_Page_Detail_Display");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 01: verifyMenuDanSinhDisplay");
		Assert.assertTrue(articlePageObject.isMenuDanSinhDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 02: verifyMenuThoiSuDisplay");
		Assert.assertTrue(articlePageObject.isMenuThoiSuDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 03: verifyArticleDateTimeDisplay");
		Assert.assertTrue(articlePageObject.isArticleDateTimeDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 04: verifyLocationDisplay");
		Assert.assertTrue(articlePageObject.isLocationDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 05: verifyDescriptionDisplay");
		Assert.assertTrue(articlePageObject.isDescriptionDisplay());
		
		paragraph_dymamic_text = "Nhá nhem tối mỗi ngày, ông Quân, 60 tuổi, lại dạo quanh khu vườn của gia đình ở xã Hà Ngọc, huyện Hà Trung, để thăm đàn cò đang chao nghiêng trên những bụi tre. Thói quen này được ông duy trì hơn 10 năm qua. \"Tôi coi đàn chim trời như bạn. Ngày nào không nhìn thấy chúng bay lượn, không được nghe tiếng ríu rít là thấy thiếu vắng, ăn không ngon miệng...\", ông Quân tâm sự.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 06: verifyParagraph1Display");
		Assert.assertTrue(articlePageObject.isParagraph1Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Từ nhỏ, ông Quân đã rất yêu thích các loài chim. Nhiều lần chứng kiến đàn chim hoang dã bị thợ săn giăng lưới hoặc bắn hạ mang đi bán thịt, ông bảo \"rất xót xa, cần có hành động\". Trong một lần về Hà Ngọc, thấy giữa cánh đồng hoang vu có nhiều loài cò bợ thường bay về trú ngụ, ông nảy sinh ý định biến nơi đây thành ngôi nhà cho lũ chim hoang đến ở.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 07: verifyParagraph2Display");
		Assert.assertTrue(articlePageObject.isParagraph2Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Năm 2004, gia đình ông Quân nhận thầu khu đầm lầy 8 ha tại xã Hà Ngọc. Lúc đó cả vùng như bãi đất chết, chỉ có lau sậy mọc hoang, ít dấu chân người qua lại. Ông thuê người trồng 50 bụi tre, đào đất đắp đường, xây tường rào bao quanh nhằm bảo vệ đàn cò thoát nạn săn bắn.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 08: verifyParagraph3Display");
		Assert.assertTrue(articlePageObject.isParagraph3Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Tre mọc đến đâu, cò về trú ẩn đến đó. Đến năm 2014, được chính quyền giao thêm hơn 10 ha đất ở khu lân cận, ông Quân quy hoạch thành vùng chăn nuôi và trồng cây ăn quả, phần còn lại trồng tre, luồng cho cò trú ngụ.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 09: verifyParagraph4Display");
		Assert.assertTrue(articlePageObject.isParagraph4Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "\"Nhiều người bảo tôi khùng, nhưng tôi cứ làm với tất cả đam mê...\", ông chủ vườn cò chia sẻ. Hiện số lượng cò làm tổ, sinh nở trong khu vườn của gia đình ông Quân lên tới hàng chục nghìn con. Ngoài các loài cò lửa, cò nhện còn có bồ nông, sáo sậu, bìm bịp...";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 10: verifyParagraph5Display");
		Assert.assertTrue(articlePageObject.isParagraph5Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "\"Mừng là mỗi năm cò về càng nhiều, chứng tỏ đất lành chim đậu. Mỗi lần vào ngắm đồi cò, tôi cảm thấy sức khỏe tốt hơn lên và cảm nhận rõ hơn sự nhỏ bé của mình trước thiên nhiên...\", ông Quân chia sẻ.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 11: verifyParagraph6Display");
		Assert.assertTrue(articlePageObject.isParagraph6Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Từ khi gần gũi với vườn cò, ông Quân yêu cầu gia đình không mua hay sử dụng thịt chim trời. Có lần vài người bạn mời ăn thịt chim đặc sản, ông khước từ giận dữ vì \"tưởng tượng như lũ chim ở nhà bị bắn chết khi bay xa kiếm ăn...\".";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 12: verifyParagraph7Display");
		Assert.assertTrue(articlePageObject.isParagraph7Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Để bảo vệ đàn chim, ông Quân còn thuê nhiều nhân công vừa chăm sóc cây trồng vừa canh chừng không cho người lạ săn bắn. Bà Bùi Thị Thắm, công nhân trong trang trại, cho hay hàng ngày đi kiểm tra xem chim cò bị thương hay không. Con nào bị dính bẫy lưới thì gỡ, những con bị bệnh chết thì đem chôn, rảnh thì bà dùng dao phát quang cây bụi cho chim lấy chỗ làm tổ, sinh nở.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 13: verifyParagraph8Display");
		Assert.assertTrue(articlePageObject.isParagraph8Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Nói về dự định tương lai, ông Quân cho hay sẽ tiếp tục bảo vệ đàn cò và định hướng phát triển nơi đây thành khu du lịch sinh thái gần gũi với thiên nhiên, giúp nâng cao ý thức bảo vệ môi trường trong cộng đồng.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 14: verifyParagraph9Display");
		Assert.assertTrue(articlePageObject.isParagraph9Display(paragraph_dymamic_text));
		
		paragraph_dymamic_text = "Đánh giá cao mô hình trang trại và hành động bảo vệ các loài chim hoang dã của ông Quân, ông Nguyễn Minh Tấn, Chủ tịch xã Hà Ngọc, cho biết đây là vườn cò duy nhất ở huyện Hà Trung nên rất cần được bảo tồn và nhân rộng. Chính quyền đang xem xét, tạo điều kiện để thành lập khu du lịch sinh thái ở nơi này nhằm phát huy hơn nữa giá trị của vùng đất.";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 15: verifyParagraph10Display");
		Assert.assertTrue(articlePageObject.isParagraph10Display(paragraph_dymamic_text));
		
		image_dymamic_text = "Cò đậu chi chít trên rặng tre mỗi buổi tối mùa đông. Ảnh: Lê Hoàng";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 16: verifyImage1Display");
		Assert.assertTrue(articlePageObject.isImage1Display(image_dymamic_text));
		
		caption_dymamic_text = "Cò đậu trên rặng tre mỗi buổi tối mùa đông. Ảnh: ";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 17: verifyCaptionImage1Display");
		Assert.assertTrue(articlePageObject.isCaptionImage1Display(caption_dymamic_text));
		
		image_dymamic_text = "Ông Mai Văn Quân. Ảnh:";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 18: verifyImage2Display");
		Assert.assertTrue(articlePageObject.isImage2Display(image_dymamic_text));
		
		caption_dymamic_text = "Ông Mai Văn Quân. Ảnh:";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 19: verifyCaptionImage2Display");
		Assert.assertTrue(articlePageObject.isCaptionImage2Display(caption_dymamic_text));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 20: verifyVideoDisplay");
		Assert.assertTrue(articlePageObject.isVideoDisplay());
		
		caption_dymamic_text = "Đàn cò bay lượn trên khu rừng của ông Quân. Video: ";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 21: verifyCaptionVideoDisplay");
		Assert.assertTrue(articlePageObject.isCaptionVideoDisplay(caption_dymamic_text));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_Verify_Section_Page_Detail_Display - Step 22: verifyAuthorNameDisplay");
		Assert.assertTrue(articlePageObject.isAuthorNameDisplay());
		
	}
	
	@Test
	public void TC_04_Verify_Social_Left_Item_Display(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_04_Verify_Social_Left_Item_Display");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_Verify_Social_Left_Item_Display - Step 01: verifyBackLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isSocialLeftBackDisplay());
		
		social_left_dymamic_title = "Chia sẻ bài viết lên facebook";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_Verify_Social_Left_Item_Display - Step 02: verifyFacebookLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isSocialLeftFacebookDisplay(social_left_dymamic_title));
		
		social_left_dymamic_title = "Chia sẻ bài viết lên twitter";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_Verify_Social_Left_Item_Display - Step 03: verifyTwitterLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isSocialLeftTwitterDisplay(social_left_dymamic_title));
		
		social_left_dymamic_title = "Chia sẻ bài viết lên Linkedin";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_Verify_Social_Left_Item_Display - Step 04: verifyLinkedInLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isSocialLeftLinkedInDisplay(social_left_dymamic_title));
		
		social_left_dymamic_title = "Bình luận";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_Verify_Social_Left_Item_Display - Step 05: verifyCommentLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isSocialLeftCommentDisplay(social_left_dymamic_title));
		
		social_left_dymamic_title = "In";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_Verify_Social_Left_Item_Display - Step 06: verifyPrintLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isSocialLeftCommentDisplay(social_left_dymamic_title));
	}
	
	
	@Test
	public void TC_05_Verify_Footer_Content_Item_Display(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_05_Verify_Footer_Content_Item_Display");
		
		footer_content_dymamic_class = "tw";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_Verify_Footer_Content_Item_Display - Step 01: verifyTwitterLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isFooterContentTwitterDisplay(footer_content_dymamic_class));
		
		footer_content_dymamic_class = "mail";
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_Verify_Footer_Content_Item_Display - Step 02: verifyMailLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isFooterContentMailDisplay(footer_content_dymamic_class));
		
		footer_content_dymamic_class = "fb";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_Verify_Footer_Content_Item_Display - Step 03: verifyFacebookLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isFooterContentFacebookDisplay(footer_content_dymamic_class));
		
		footer_content_dymamic_class = "copy";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_Verify_Footer_Content_Item_Display - Step 04: verifyCopyAndPasteLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isFooterContentCopyAndPasteDisplay(footer_content_dymamic_class));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_Verify_Footer_Content_Item_Display - Step 05: verifySaveLogoButtonDisplay");
		Assert.assertTrue(articlePageObject.isFooterContentSaveDisplay());
	}
	
	
	public void sleepInSecond(long timeoutInSec){
		
		try {
			
			Thread.sleep(timeoutInSec * 1000);
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}