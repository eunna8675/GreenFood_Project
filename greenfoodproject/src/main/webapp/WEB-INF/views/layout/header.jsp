<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="app" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="" href="">
<meta charset="UTF-8">
</head>
<body>
        <!-- start header -->
        <header>
            <!-- start navigation -->
            <nav class="navbar top-space navbar-expand-lg navbar-boxed navbar-light bg-transparent header-light fixed-top header-reverse-scroll">
                <div class="container-fluid nav-header-container">
                    <div class="col-auto col-sm-6 col-lg-2 mr-auto pl-lg-0">
                        <a class="navbar-brand" href="${app }/">
                            <img src="${app }/resources/images/logo-black.png" data-at2x="resources/images/logo-black@2x.png" alt="" class="default-logo">
                            <img src="${app }/resources/images/logo-neon-orange.png" data-at2x="resources/images/logo-neon-orange@2x.png" alt="" class="alt-logo">
                            <img src="${app }/resources/images/logo-neon-orange.png" data-at2x="resources/images/logo-neon-orange@2x.png" class="mobile-logo" alt="">
                        </a>
                    </div>
                    <div class="col-auto menu-order px-lg-0">
                        <button class="navbar-toggler float-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-label="Toggle navigation">
                            <span class="navbar-toggler-line"></span>
                            <span class="navbar-toggler-line"></span>
                            <span class="navbar-toggler-line"></span>
                            <span class="navbar-toggler-line"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                            <ul class="navbar-nav alt-font">
                               <li class="nav-item dropdown megamenu">
                                    <a href="#" class="nav-link" style="pointer-events: none;">카테고리</a>
                                    <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown" aria-hidden="true"></i>
                                    <div class="menu-back-div dropdown-menu megamenu-content" role="menu">
                                        <div class="d-lg-flex justify-content-center">
                                            <ul class="d-lg-inline-block">
                                                <li class="dropdown-header">레시피 카테고리</li>
                                                <li value="0"><a href="${app}/recipe/foodCategory/all">ALL</a></li>
                                                <li value="1"><a href="${app}/recipe/foodCategory/1">밥류</a></li>
                                                <li value="2"><a href="${app}/recipe/foodCategory/2">면 및 만두류</a></li>
                                                <li value="3"><a href="${app}/recipe/foodCategory/3">죽 및 스프류</a></li>
                                                <li value="4"><a href="${app}/recipe/foodCategory/4">국 및 탕류</a></li>
                                                <li value="5"><a href="${app}/recipe/foodCategory/5">찌개 및 전골류</a></li>
                                                <li value="6"><a href="${app}/recipe/foodCategory/6">찜류</a></li>
                                                <li value="7"><a href="${app}/recipe/foodCategory/7">구이류</a></li>
                                                <li value="8"><a href="${app}/recipe/foodCategory/8">전 및 부침류</a></li>
                                                <li value="9"><a href="${app}/recipe/foodCategory/9">볶음류</a></li>
                                                <li value="10"><a href="${app}/recipe/foodCategory/10">조림류</a></li>
                                                <li value="11"><a href="${app}/recipe/foodCategory/11">튀김류</a></li>
                                                <li value="12"><a href="${app}/recipe/foodCategory/12">나물 및 숙채류</a></li>
                                                <li value="13"><a href="${app}/recipe/foodCategory/13">생채 및 무침류</a></li>
                                                <li value="14"><a href="${app}/recipe/foodCategory/14">장 및 앙념류</a></li>
                                            </ul>
                                            <ul class="d-lg-inline-block">
                                                <li class="dropdown-header">레시피</li>
                                                <% if(session.getAttribute("id") == null){ %>
                                                <li><a href="login">나의 레시피 보기</a></li>
                                                <%}else if(session.getAttribute("id") != null){ %>
                                                <li><a href="login">나의 레시피 보기</a></li>
                                                <%} %>
                                            </ul>
                                            <ul class="d-lg-inline-block">
                                                <li class="dropdown-header">레시피 상품</li>
                                                <li><a href="home-design-agency.html">상품 목록 보기</a></li>
                                       
                                            </ul>
                                            <ul class="d-lg-inline-block">
                                                <li class="dropdown-header">고객센터</li>
                                                <li><a href="${app }/serviceCenter">상담/찾아오시는 길</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item dropdown simple-dropdown">
                                    <a href="${app }/recipe/foodCategory/all" class="nav-link">레시피 카테고리</a>
                                    <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown" aria-hidden="true"></i>
                                </li>
                                <li class="nav-item dropdown simple-dropdown">
                                <% if(session.getAttribute("id") == null){ %>
                                    <a href="${pageContext.request.contextPath}/login" class="nav-link">레시피 등록</a>
                                    <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown" aria-hidden="true"></i>
                                <% }else if(session.getAttribute("id") != null){ %>
                                	<a href="${pageContext.request.contextPath}/recipePost" class="nav-link">레시피 등록</a>
                                    <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown" aria-hidden="true"></i>
                                <%} %>
                                </li>
                                <li class="nav-item dropdown megamenu">
                                    <a href="javascript:void(0);" class="nav-link">레시피 상품</a>
                                    <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown" aria-hidden="true"></i>
                                </li>
                                <li class="nav-item dropdown simple-dropdown">
                                    <a href="${app}/serviceCenter" class="nav-link">고객센터</a>
                                    <i class="fa fa-angle-down dropdown-toggle" data-toggle="dropdown" aria-hidden="true"></i>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-auto text-right pr-0 font-size-0">
                        <div class="header-search-icon search-form-wrapper">
                            <a href="javascript:void(0)" class="search-form-icon header-search-form"><i class="feather icon-feather-search"></i></a>
                            <!-- start search input --> 
                            <div class="form-wrapper">
                                <button title="Close" type="button" class="search-close alt-font">×</button>
                                <form id="search-form" role="search" method="get" class="search-form text-left" action="${app}/reciep">
                                    <div class="search-form-box">
                                        <span class="search-label alt-font text-small text-uppercase text-medium-gray">어떤 레시피가 궁금하신가요?</span>
                                        <input class="search-input alt-font" id="search-form-input5e219ef164995" placeholder="검색어를 입력해 주세요." name="keyword" value="" type="text" autocomplete="on">
                                        <button type="submit" class="search-button">
                                            <i class="feather icon-feather-search" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                    
                                </form>
                            </div>
                            <!-- end search input --> 
                        </div>
                        
                          <!-- search with ingredients button start-->
                        <div class="header-search-icon search-form-wrapper">
                        	<div>
                         	   <a href="${app}/searchIngredient"><i class="feather icon-feather-grid icon-medium-ksy align-middle text-fast-black-ksy"></i></a>
                        	</div>
                        </div>
                        <!-- search with ingredients button ends-->                      
                        
                        
                        <div class="header-language dropdown d-lg-inline-block">
                            <a href="javascript:void(0);"><i class="feather icon-feather-users"></i></a>
                            <ul class="dropdown-menu alt-font">
                            <% if(session.getAttribute("id") == null){ %>
                                <li><a href="${app}/login"  title="로그인"><span class="icon-country"><img src="${app }/resources/images/user.png" alt=""></span>로그인</a></li>
                                <li><a href="${app}/register" title="회원가입"><span class="icon-country"><img src="${app }/resources/images/user.png" alt=""></span>회원가입</a></li>
                            <% }else if(session.getAttribute("id").equals("admin")){%>
                            	<li><a href="login" title="관리자페이지"><span class="icon-country"><img src="${app }/resources/images/user.png" alt=""></span>관리자페이지</a></li>
                                <li><a href="${app}/logout"  title="로그아웃"><span class="icon-country"><img src="${app }/resources/images/user.png" alt=""></span>로그아웃</a></li>
                            <%}else if(session.getAttribute("id") != null){ %>
                            	<li><a href="${app}/myinfo"  title="마이페이지"><span class="icon-country"><img src="${app }/resources/images/user.png" alt=""></span>마이페이지</a></li>
                            	<li><a href="${app}/orderlist"  title="결제내역"><span class="icon-country"><img src="resources/images/user.png" alt=""></span>결제내역</a></li>
                                <li><a href="${app}/logout"  title="로그아웃"><span class="icon-country"><img src="${app }/resources/images/user.png" alt=""></span>로그아웃</a></li>
                            <%} %>
                            </ul>
                        </div>
                        <div class="header-cart-icon dropdown">
                            <a href="javascript:void(0);"><i class="feather icon-feather-shopping-bag"></i><span class="cart-count alt-font bg-dark-orange text-white">2</span></a>
                            <ul class="dropdown-menu cart-item-list">
                            <% if(session.getAttribute("id") != null){ %>
                                <li class="cart-item align-items-center">
                                    <div class="product-image">
                                        <a href="single-product.html"><img src="${app }/resources/images/c.jpg"" class="cart-thumb" alt="" /></a>
                                    </div>
                                    <div class="product-detail alt-font">
                                        <a href="single-product.html">치킨 샐러드</a>
                                        <span class="item-ammount">10,000원</span> 
                                    </div>
                                </li>
                   			<%} %>
                                <li class="cart-item cart-total">
                                    <div class="alt-font margin-15px-bottom"><span class="w-50 d-inline-block text-medium text-uppercase">합계:</span><span class="w-50 d-inline-block text-right text-medium font-weight-500">19,999원</span></div>
                                    <% if(session.getAttribute("id") == null){ %>
                                    <a href="${app}/login"  class="btn btn-small btn-dark-gray">로그인</a>
                                    <%}else if(session.getAttribute("id") != null){ %>
                                    <a href="${app}/shoppingcart"  class="btn btn-small btn-dark-gray">장바구니</a>
                                    <%} %>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        <!-- end header -->
</body>
</html>