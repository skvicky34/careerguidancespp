
		
	<footer>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
             <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-12 text-white">
                            <div class="row p-3">
                                <div class="col-md-8 col-12 text-right">
                                    <p class="m-0">All Right Reserved 2020 - <a href="http://careerguidance.com/" target="_blank">careerguidance.com</a></p>
                                </div>
                                <div class="col-md-3 col-6 footer-icon text-right">
                                   <a target="_blank"href="https://twitter.com/HCLEnterprise?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"> <i class="fa fa-twitter"></i></a>
                                  <a target="_blank" href="https://www.facebook.com/HCLTechnologies/">  <i class="fa fa-facebook"></i></a>
                                   <a target="_blank" href="https://www.hcltech.com/cloud/google-cloud"> <i class="fa fa-google"></i></a>
                                   <a target="_blank" href="https://www.linkedin.com/company/hcl-technologies"> <i class="fa fa-linkedin"></i></a>
                                   <a href="#"> <i class="fa fa-youtube"></i></a>
                                  <a href="#"> <i class="fa fa-vimeo"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        
        
      </div>
    </div>
  </footer>

  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/isotope.min.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/lightbox.js"></script>
    <script src="assets/js/tabs.js"></script>
    <script src="assets/js/video.js"></script>
    <script src="assets/js/slick-slider.js"></script>
    <script src="assets/js/custom.js"></script>
    
    
    
    
    <script>
        //according to loftblog tut
        $('.nav li:first').addClass('active');

        var showSection = function showSection(section, isAnimate) {
          var
          direction = section.replace(/#/, ''),
          reqSection = $('.section').filter('[data-section="' + direction + '"]'),
          reqSectionPos = reqSection.offset().top - 0;

          if (isAnimate) {
            $('body, html').animate({
              scrollTop: reqSectionPos },
            800);
          } else {
            $('body, html').scrollTop(reqSectionPos);
          }

        };

        var checkSection = function checkSection() {
          $('.section').each(function () {
            var
            $this = $(this),
            topEdge = $this.offset().top - 80,
            bottomEdge = topEdge + $this.height(),
            wScroll = $(window).scrollTop();
            if (topEdge < wScroll && bottomEdge > wScroll) {
              var
              currentId = $this.data('section'),
              reqLink = $('a').filter('[href*=\\#' + currentId + ']');
              reqLink.closest('li').addClass('active').
              siblings().removeClass('active');
            }
          });
        };

        $('.main-menu, .scroll-to-section').on('click', 'a', function (e) {
          if($(e.target).hasClass('external')) {
            return;
          }
          e.preventDefault();
          $('#menu').removeClass('active');
          showSection($(this).attr('href'), true);
        });

        $(window).scroll(function () {
          checkSection();
        });
    </script>
    
    </body>
</html>