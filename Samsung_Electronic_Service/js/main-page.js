$(document).ready(function(){
    
    // 기능 (1) popup 이미지 좌 우로 화면이 넘어간다.
    $(".popup-images:first").clone(true).insertAfter(".popup-images:last");
    $(".popup-imgbox-inner").css("left","-400px");
    function paint_carousel_bg(){
        if($(".popup-images").eq(1).children("img").attr("src")=="images/popup-img02.jpg"){
            $(".carousel-btn:last").css("background-color","#000");
            $(".carousel-btn:first").css("background-color","#fff");
        } else {
            $(".carousel-btn:last").css("background-color","#fff");
            $(".carousel-btn:first").css("background-color","#000");
        }
       };
    $(".popup-img-next").click(function(){
        $(".popup-imgbox-inner").animate({left:"-800px"},500,function(){
            $(".popup-images:first").remove();
            $(".popup-images:first").clone(true).insertAfter(".popup-images:last");
            $(".popup-imgbox-inner").css("left","-400px");
            paint_carousel_bg();
        });
    })
    $(".popup-img-prev").click(function(){
        $(".popup-imgbox-inner").animate({left:"0px"},500,function(){
            $(".popup-images:last").remove();
            $(".popup-images:last").clone(true).insertBefore(".popup-images:first");
            $(".popup-imgbox-inner").css("left","-400px");
            paint_carousel_bg();
        });
   
    })
    // 기능 (1) 끝

    // 기능 (2) 팝업 닫기버튼
    $(".stop-and-closebox a").click(function(){
        $("#popup_outer").css("display","none");
    })
    // 기능 (2) 끝

    // 기능 (3) 메인메뉴 마우스 올리면 서브메뉴 및 효과 실행
    let top_menu_indexNum;
    $(".top_menu_item a").on({
        mouseenter:function(){
            if(brower_width > 1450){
                $(".top_sub_menubox_outer").slideDown(500);
                top_menu_indexNum = $(".top_menu_item a").index(this);

                $(".top_sub_menubox").eq(top_menu_indexNum).css({
                    backgroundColor:"#007aff",
                    color:"#fff"
                });
                $(".top_sub_menubox").not($(".top_sub_menubox").eq(top_menu_indexNum)).css({
                    backgroundColor:"",
                    color:""
                });
            }
        }
    });
    $(".top_sub_menubox").on({
        mouseenter:function(){
            $(this).css({
                backgroundColor:"#007aff",
                color:"#fff"
            });
            $(this).siblings(".top_sub_menubox").css({
                backgroundColor:"",
                color:""
            });
        }
    });
    $(".top_sub_menubox_outer").mouseleave(function(){
        $(this).slideUp(500);
    });
    $(".top_sub_menubox dd").on({
        mouseenter:function(){
            $(this).css("cursor","pointer");
        }
    })
    // 수정중
    $(".top_sub_menubox dt").click(function(){
        if(brower_width < 1400){
            $(this).closest(".top_sub_menubox").siblings().children("dd").slideUp(500);
            $(this).siblings("dd").slideDown(500);
        }
    })

    $(".top_sub_menubox_inner").mouseleave(function(){
        if(brower_width < 1400){
            $(".top_sub_menubox dd").slideUp();
            console.log("hi");
        }
    })
    // 수정중

    // 기능 (3) 끝

    // 기능 (4) 슬라이드 자동 회전
    let slide_auto_move = setInterval(play,3000);
    function play(){
        $("#slide_next_btn").click();
    }
    // 기능(4) 끝
    
    
    // 기능(5) 슬라이더 수동 회전
    let slide_indexNum = 0;
    
    $("#slide_next_btn").click(function(){
        clearInterval(slide_auto_move);
        slide_indexNum++;
        if(slide_indexNum < 5){
            $(".slide_position_box li").eq(slide_indexNum).css("background-color","#000").siblings("li").css("background-color","#fff");
        }else{
            $(".slide_position_box li").eq(0).css("background-color","#000").siblings("li").css("background-color","#fff");
        }
        
        if(brower_width > 1400){
            $(".slide_imagebox_outer").stop().animate({left:-(slide_indexNum*3200+6400)},1000,function(){
                if(slide_indexNum == 5){
                    slide_indexNum=0;
                    $(".slide_imagebox_outer").css("left",-6400);
                    $(".slide_imagebox_inner:first-of-type").remove();
                    $(".slide_imagebox_inner:last-of-type").remove();
                    $(".slide_imagebox_inner").eq(4).clone(true).insertAfter(".slide_imagebox_inner:last-of-type");
                    $(".slide_imagebox_inner").eq(4).clone(true).insertBefore(".slide_imagebox_inner:first-of-type");
                }
            });
        } else if(brower_width <= 1400){
            $(".slide_imagebox_outer").stop().animate({left:-(slide_indexNum*(brower_width*2)+brower_width*4)},1000,function(){
                if(slide_indexNum == 5){
                    slide_indexNum=0;
                    $(".slide_imagebox_outer").css("left",-(brower_width*4));
                    $(".slide_imagebox_inner:first-of-type").remove();
                    $(".slide_imagebox_inner:last-of-type").remove();
                    $(".slide_imagebox_inner").eq(4).clone(true).insertAfter(".slide_imagebox_inner:last-of-type");
                    $(".slide_imagebox_inner").eq(4).clone(true).insertBefore(".slide_imagebox_inner:first-of-type");
                }
            });
        }

        slide_auto_move = setInterval(play,3000);
        if(slide_indexNum == 4){
            $(".slide_imagebox_inner").eq(0).clone(true).insertAfter(".slide_imagebox_inner:last-of-type");
            $(".slide_imagebox_inner").eq(0).clone(true).insertBefore(".slide_imagebox_inner:first-of-type");
        } else if (slide_indexNum == 1 && $(".slide_imagebox_inner").length == 7) {
            $(".slide_imagebox_inner:first-of-type").remove();
            $(".slide_imagebox_inner:last-of-type").remove();
        }
    });

    $("#slide_prev_btn").click(function(){
        clearInterval(slide_auto_move);
        slide_indexNum--;
        if(slide_indexNum >= 0 ){
            $(".slide_position_box li").eq(slide_indexNum).css("background-color","#000").siblings("li").css("background-color","#fff");
        }else{
            $(".slide_position_box li").eq(4).css("background-color","#000").siblings("li").css("background-color","#fff");
        }
        
        if(brower_width > 1400){
            $(".slide_imagebox_outer").stop().animate({left:-(slide_indexNum*3200+6400)},1000,function(){
                if(slide_indexNum == -1){
                    slide_indexNum = 4;
                    $(".slide_imagebox_outer").css("left",-19200);
                    $(".slide_imagebox_inner:first-of-type").remove();
                    $(".slide_imagebox_inner:last-of-type").remove();
                    $(".slide_imagebox_inner").eq(0).clone(true).insertAfter(".slide_imagebox_inner:last-of-type");
                    $(".slide_imagebox_inner").eq(0).clone(true).insertBefore(".slide_imagebox_inner:first-of-type");
                }
            });
        } else if(brower_width <= 1400){
            $(".slide_imagebox_outer").stop().animate({left:-(slide_indexNum*(brower_width*2)+brower_width*4)},1000,function(){
                if(slide_indexNum == -1){
                    slide_indexNum = 4;
                    $(".slide_imagebox_outer").css("left",-(brower_width*12));
                    $(".slide_imagebox_inner:first-of-type").remove();
                    $(".slide_imagebox_inner:last-of-type").remove();
                    $(".slide_imagebox_inner").eq(0).clone(true).insertAfter(".slide_imagebox_inner:last-of-type");
                    $(".slide_imagebox_inner").eq(0).clone(true).insertBefore(".slide_imagebox_inner:first-of-type");
                }
            });
        }
        
        slide_auto_move = setInterval(play,3000);
        if(slide_indexNum == 0){
            $(".slide_imagebox_inner").eq(4).clone(true).insertAfter(".slide_imagebox_inner:last-of-type");
            $(".slide_imagebox_inner").eq(4).clone(true).insertBefore(".slide_imagebox_inner:first-of-type");
        } else if (slide_indexNum == 3 && $(".slide_imagebox_inner").length == 7) {
            $(".slide_imagebox_inner:first-of-type").remove();
            $(".slide_imagebox_inner:last-of-type").remove();
        }
    });
    
    // 기능 (5) 끝

    // 기능(6) 태블릿 화면에서 main slide banner 변경하기
    let brower_width = $(window).width();
    let slide_visible_width = $(".slide_imagebox_visible").css("width");
    $(window).resize(function(){
        brower_width = $(window).width();
        if(brower_width>1400){
            $(".slide_imagebox_inner img").eq(0).attr("src","./images/slide-img01.jpg")
            $(".slide_imagebox_inner img").eq(1).attr("src","./images/slide-img02.jpg")
            $(".slide_imagebox_inner img").eq(2).attr("src","./images/slide-img03.jpg")
            $(".slide_imagebox_inner img").eq(3).attr("src","./images/slide-img04.jpg")
            $(".slide_imagebox_inner img").eq(4).attr("src","./images/slide-img05.jpg")

            clearInterval(slide_auto_move);
            $(".slide_imagebox_outer").css({
                right:-12800,
                left:-6400
            });
            $(".slide_imagebox_inner").css("width","1600px");
            slide_indexNum = 0;
            slide_auto_move = setInterval(play,3000);
        } else if(brower_width < 1400){
            $(".slide_imagebox_inner img").eq(0).attr("src","./images/tablet-slide-img01.jpg")
            $(".slide_imagebox_inner img").eq(1).attr("src","./images/tablet-slide-img02.jpg")
            $(".slide_imagebox_inner img").eq(2).attr("src","./images/tablet-slide-img03.jpg")
            $(".slide_imagebox_inner img").eq(3).attr("src","./images/tablet-slide-img04.jpg")
            $(".slide_imagebox_inner img").eq(4).attr("src","./images/tablet-slide-img05.jpg")

            $(".slide_imagebox_inner").css("width",$(".slide_imagebox_visible").css("width"));
            $(".slide_imagebox_outer").css({
                right:-$(window).width()*8,
                left:-$(window).width()*4
            });
            $(".slide_position_box li").eq(0).css("background-color","#000").siblings("li").css("background-color","#fff");
            slide_indexNum = 0;

            $(".service_tip").css("left","0");
            service_tip_slide_indexNum = 0;
        }
    })
    // 기능(6) 종료
    
    // 기능(7) 처음 로딩시 윈도우 사이즈에 따라 slide 사이드 설정
    if(brower_width > 1400){
        $("#slide_next_btn").click();
        // return;
    } else if(brower_width <= 1400){
            $("#slide_next_btn").click();
            $(".slide_imagebox_inner img").eq(0).attr("src","./images/tablet-slide-img01.jpg")
            $(".slide_imagebox_inner img").eq(1).attr("src","./images/tablet-slide-img02.jpg")
            $(".slide_imagebox_inner img").eq(2).attr("src","./images/tablet-slide-img03.jpg")
            $(".slide_imagebox_inner img").eq(3).attr("src","./images/tablet-slide-img04.jpg")
            $(".slide_imagebox_inner img").eq(4).attr("src","./images/tablet-slide-img05.jpg")

            $(".slide_imagebox_inner").css("width",$(".slide_imagebox_visible").css("width"));
            $(".slide_imagebox_outer").css({
                right:-$(window).width()*8,
                left:-$(window).width()*4
            });
    }
    //기능(7)
    
    // 기능(8) service tip 이미지 이동
    let service_tip_slide_indexNum = 0
    
    $(".service_tip_next_btn").click(function(){
        service_tip_slide_indexNum++;
        
        if(brower_width > 1400){
            if(service_tip_slide_indexNum > 1){
                service_tip_slide_indexNum = 1;
                return;
            }
            let service_slide_box_width = $(".service_tip_slide_box_inner").css("width");
            $(".service_tip").animate({left:`-=${service_slide_box_width}`},500);
        } else if (brower_width <= 1400){
            if(service_tip_slide_indexNum > 3){
                service_tip_slide_indexNum = 3;
                return
            }
            let service_slide_box_width = $(".service_tip_slide_box_inner").css("width");
            $(".service_tip").animate({left:`-=${service_slide_box_width}`},500);
        }
        
        
    });

    $(".service_tip_prev_btn").click(function(){
        service_tip_slide_indexNum--;
        if(brower_width > 1400){
            if(service_tip_slide_indexNum < 0){
                service_tip_slide_indexNum = 0;
                return;
            }
            let service_slide_box_width = $(".service_tip_slide_box_inner").css("width");
            $(".service_tip").animate({left:`+=${service_slide_box_width}`},500);
        } else if (brower_width <= 1400){
            if(service_tip_slide_indexNum < 0){
                service_tip_slide_indexNum = 0;
                return;
            }
            let service_slide_box_width = $(".service_tip_slide_box_inner").css("width");
            $(".service_tip").animate({left:`+=${service_slide_box_width}`},500);
        }
        
    })
    // 기능(8) 끝

    

    // 기능(9)
    $(".top_menubox_toggle").click(function(){
        if($(".top_sub_menubox_outer").css("display") == "none")
            $(".top_sub_menubox_outer").slideDown(500);
        else {
            $(".top_sub_menubox_outer").slideUp(500);
        }
    })
    // 기능(9) 끝

    // 기능(10) 
    $(".service_tip li img:last-of-type").on({
        mouseenter:function(){
            if(brower_width > 940){
                $(this).css({
                    transform: "scale(1.3)",
                    bottom:0
                });
                $(this).parent(".hidden_box").parent("li").css("overflow","visible");
            }
        },
        mouseleave:function(){
            if(brower_width> 940){
                $(this).css({
                    transform: "scale(1.0)",
                    bottom:""
                })
                $(".service_tip li").css("overflow","hidden");
            }
        }
    })
    // 기능 (10) 끝

    // 기능 (11)
    let quickBox_clicked = false;
    $(".open_quick_button_outer").click(function(){
        if(quickBox_clicked == false){
            $(".open_quick_button_outer").css("transform","rotate(360deg)");
            console.log("hi");
            $(".quick_link").css("display","block");
            $(".quick_link:nth-of-type(1)").stop().animate({bottom:260},500);
            $(".quick_link:nth-of-type(2)").stop().animate({bottom:170},500);
            $(".quick_link:nth-of-type(3)").stop().animate({bottom:80},500);
            quickBox_clicked = true;
        }else {
            $(".open_quick_button_outer").css("transform","rotate(0deg)");
            $(".quick_link:nth-of-type(1)").animate({bottom:"-10px"},500,function(){
                $(".quick_link").css("display","none");
            });
            $(".quick_link:nth-of-type(2)").animate({bottom:"-10px"},500,function(){
                $(".quick_link").css("display","none");
            });
            $(".quick_link:nth-of-type(3)").animate({bottom:"-10px"},500,function(){
                $(".quick_link").css("display","none");
            });
            quickBox_clicked = false;
        }
    })


    $(".quick_link").on({
        mouseenter:function(){
            $(this).stop().animate({
                borderRadius:"25px",
                width:"300px"
            },500,function(){
               $(this).children("p").stop().fadeIn(300);
            })
        },
        mouseleave:function(){
            $(this).children("p").css("display","none");
            $(this).stop().animate({
                borderRadius:"50%",
                width:"80px"
            },500)
        }
    })

    

});