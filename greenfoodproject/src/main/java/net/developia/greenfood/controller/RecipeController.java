package net.developia.greenfood.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;
import lombok.extern.slf4j.Slf4j;
import net.developia.greenfood.dto.ArticleDTO;
import net.developia.greenfood.dto.Article_HashDTO;
import net.developia.greenfood.dto.IngredientsDTO;
import net.developia.greenfood.dto.RecipeDTO;
import net.developia.greenfood.dto.Recipe_IngredientsDTO;
import net.developia.greenfood.dto.Recipe_StepDTO;
import net.developia.greenfood.service.AwsService;
import net.developia.greenfood.service.RecipeService;

@Controller
@Slf4j
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	@Autowired
	private AwsService awsService;
	
	int recipe_no = 0;

	@RequestMapping(value = "/recipe", method = RequestMethod.GET)
	public String home2() {
		System.out.println("recipe page start");
		return "recipePage2";
	}

	@RequestMapping(value = "/recipePost", method = RequestMethod.GET)
	public String recipePost() {
		System.out.println("recipe page start");
		return "recipePost";
	}

	@PostMapping(value = "/taglist", produces = "application/text; charset=utf8")
	public @ResponseBody String getHashtagList() throws Exception {
		List<RecipeDTO> hashtag_list = recipeService.getHashtagList();
		String json = new Gson().toJson(hashtag_list);

		return json;
	}

	@PostMapping(value = "/catlist", produces = "application/text; charset=utf8")
	public @ResponseBody String getFoodcategoryList() throws Exception {
		List<RecipeDTO> cat_list = recipeService.getFoodcategoryList();
		String json = new Gson().toJson(cat_list);

		return json;
	}

	/*
	 * @PostMapping(value="/titleviewchk", produces =
	 * "application/text; charset=utf8") public @ResponseBody String
	 * viewChceck(@RequestParam(value="ingredientssize[]") List<String>
	 * ingredientssize,
	 * 
	 * @RequestParam(value="ingredients[]") List<String> ingredients,
	 * 
	 * @RequestParam(value="title") String title,
	 * 
	 * @RequestParam(value="subscript") String subscript,
	 * 
	 * @RequestParam(value="foodname") String foodname,
	 * 
	 * @RequestParam(value="howmuch") String howmuch) throws Exception { String chk
	 * = "1"; log.info("실행");
	 * 
	 * 
	 * //titleView
	 * 
	 * for(String is : ingredientssize) { if(is.equals("")) { chk = "0"; break; } }
	 * for(String ig : ingredients) { if(ig.equals("")) { chk = "0"; break; } } //재료
	 * 
	 * if(title.equals("") || subscript.equals("") || foodname.equals("") ||
	 * howmuch.equals("")) { chk = "0"; }
	 * 
	 * return chk; }
	 */

	/*
	 * @GetMapping("/myinfo") public ModelAndView move_myinfo(HttpSession session) {
	 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("ID",
	 * session.getAttribute("id")); ModelAndView mav = new ModelAndView("myinfo");
	 * try { memberService.selectProfile(map); Object output =
	 * map.get("MemberNickname"); if(output == null) { mav.addObject("nickname",
	 * ""); } else { mav.addObject("nickname",
	 * map.get("MemberNickname").toString()); }
	 * 
	 * mav.addObject("profile_img", map.get("MemberProfileImg").toString()); } catch
	 * (Exception e) { e.printStackTrace(); mav.addObject("nickname", "");
	 * mav.addObject("profile_img", map.get("MemberProfileImg").toString()); }
	 * return mav; }
	 */

	@PostMapping(value = "/mytag", produces = "application/text; charset=utf8")
	public @ResponseBody String myHashtahList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<String> titleList = StringProcess(request.getParameter("total_string"));
		HashMap<String, Boolean> tagmap = new HashMap<String, Boolean>();
		List<String> taglist = new ArrayList<>();
		for (int i = 0; i < titleList.size(); i++) {
			if (!tagmap.containsKey(titleList.get(i))) {
				tagmap.put(titleList.get(i), true);
				taglist.add(titleList.get(i));
			}
		}

		String json = new Gson().toJson(taglist);
		return json;
	}

	@PostMapping(value = "/postRecipe", produces = "application/text; charset=utf8")
	public @ResponseBody String insertRecipe(@RequestParam(value = "ingredientsArr[]") List<String> ingredientsArr,
			@RequestParam(value = "ingredientssizeArr[]") List<String> ingredientssizeArr,
			@RequestParam(value = "hashtagArr[]") List<String> hashtagArr, @RequestParam(value = "title") String title, //
			@RequestParam(value = "steptitleArr[]") List<String> steptitleArr,
			@RequestParam(value = "stepsubscriptArr[]") List<String> stepsubscriptArr,
			@RequestParam(value = "subscript") String subscript, //
			@RequestParam(value = "foodname") String foodname, //
			@RequestParam(value = "howmuch") String howmuch, //
			@RequestParam(value = "foodtime") String foodtime, //
			@RequestParam(value = "foodcategory") String foodcategory) throws Exception {

		RecipeDTO rdto = new RecipeDTO();
		rdto.setTitle(foodcategory);
		int cat_no = recipeService.findCategory(rdto);
		log.info("글번호" + cat_no);
		ArticleDTO adto = new ArticleDTO();
		adto.setTitle(title);
		adto.setId("eunna8675");
		adto.setExplanation(subscript);
		adto.setCookingtime(Integer.parseInt(foodtime));
		adto.setFoodname(foodname);
		adto.setHowmuch(Integer.parseInt(howmuch));
		adto.setFoodcategoryno(cat_no);
		adto.setViews(0);
		adto.setLikes(0);
		recipeService.insertRecipe(adto);
		recipe_no = recipeService.findRecipe(adto);
		log.info("글번호" + recipe_no);

		// recipe_hashtag

		for(String hasht : hashtagArr) { 
			 RecipeDTO rtmp = new RecipeDTO();
			 rtmp.setTagname(hasht); 
			 int hashno = recipeService.findHashtag(rtmp);
			 log.info(hashno +"해쉬코드 번호");
			 Article_HashDTO ahdto = new Article_HashDTO(); 
			 ahdto.setHashtag_no(hashno);
			 ahdto.setRecipe_no(recipe_no); 
			 recipeService.insertHash_Recipe(ahdto); 
		}
		 

		// ingredients
		
		List<IngredientsDTO> ingredients_list = recipeService.findIngredients(); 
		for(String iga : ingredientsArr) { 
			boolean chk = false; 
			int ino = 0; 
			int isize =0; 
			for(int i = 0; i < ingredients_list.size(); i++) { 
				if(iga.equals(ingredients_list.get(i).getName()))
				{ 
					chk = true; 
					ino = ingredients_list.get(i).getNo(); 
					isize = i; break; 
				}
			} 
			
			IngredientsDTO idto = new IngredientsDTO();
			idto.setName(iga);
			if(chk == false) {
		 	   recipeService.insertIngredients(idto); 
		 	} 
			int ingredients_no =recipeService.findIngredientsOne(idto); 
			int howm =Integer.parseInt(ingredientssizeArr.get(isize)); 
			log.info(ingredients_no+"재료번호");
			log.info(howm +"재료양");
			Recipe_IngredientsDTO ridto = new Recipe_IngredientsDTO(); 
			ridto.setHowmuch(howm);
		    ridto.setIngredients_no(ingredients_no); 
		    ridto.setRecipe_no(recipe_no);
		    recipeService.InsertRecipe_Ingredients(ridto); 
		  }
		
		 //step
		for(int i = 0; i< steptitleArr.size(); i++) { 
			String f = stepsubscriptArr.get(i);
			String s = steptitleArr.get(i);
			Recipe_StepDTO rsdto = new Recipe_StepDTO();
			rsdto.setRecipe_no(recipe_no);
			rsdto.setStep_title(s);
			rsdto.setStep_explanation(f);
			rsdto.setStep_no(i+1);
			recipeService.InsertStep(rsdto);
		}
		
		return Integer.toString(recipe_no);
	}
	
	@PostMapping("/ThumbnailUpdate.do")
	public void ThumbnailUpdate(HttpSession session, @ModelAttribute MultipartFile thumb) throws Exception {
		
//		formData.append("thumb", $("#product_image")[0].files[0]);
//		formData.append("recipe_no", retVal);
		
		String profile_img = awsService.s3FileUploadThumbnail(thumb, "eunna8675" , Integer.toString(recipe_no));
		log.info(recipe_no+"글번호입니다");
		ArticleDTO adto = new ArticleDTO();
		adto.setThumbnail(profile_img);
		adto.setNo(recipe_no);
		recipeService.updateRecipeThumbnail(adto);
		
		
	}
	
	
	@PostMapping("/StepUpdate.do")
	public void StepUpdate(HttpSession session, @ModelAttribute MultipartFile thumb) throws Exception {
		
//		formData.append("thumb", $("#product_image")[0].files[0]);
//		formData.append("recipe_no", retVal);
		
		String profile_img = awsService.s3FileUploadThumbnail(thumb, "eunna8675" , Integer.toString(recipe_no));
		log.info(recipe_no+"글번호입니다");
		ArticleDTO adto = new ArticleDTO();
		adto.setThumbnail(profile_img);
		adto.setNo(recipe_no);
		recipeService.updateRecipeThumbnail(adto);
		
		
	}

	public static List<String> StringProcess(String str) {

		List<String> titleList = new ArrayList<>();
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		String strToAnalyze = str;

		KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

		List<Token> tokenList = analyzeResultList.getTokenList();
		for (Token token : tokenList) {
			if (token.getPos().charAt(0) == 'N' && token.getPos().charAt(1) == 'N') {
				titleList.add(token.getMorph());
			}
		}
		return titleList;

	}
	
	

}
