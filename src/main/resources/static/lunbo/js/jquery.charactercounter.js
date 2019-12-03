/**
 * Character Counter Plugin for jQuery
 *
 * @version: v0.01
 * @author: serdar ozturk
 * @kokulusilgi
 */

(function($) {
    $.fn.extend( {
        characterCounter: function(limit) {
            $(this).parent().css('position','relative');
            ccinputLineHeight = parseInt($(this).css('line-height').replace('px',''))+parseInt($(this).css('padding-top').replace('px',''))+parseInt($(this).css('padding-bottom').replace('px',''));
            ccinputWidth = $(this).innerWidth();
            ccinputHeight = $(this).innerHeight();
            ccinputPos = $(this).position();
            $(this).parent().append('<div class="ccinput-counter" style="position:absolute; visibility: hidden; color:#000; z-index:911; text-align: right; top:'+ccinputPos.top+'px; height:'+ccinputHeight+'px; line-height:'+ccinputLineHeight+'px;">'+limit+'</div>');
            var ccinputEl = $('.ccinput-counter',$(this).parent());
            ccinputElWidth = ccinputEl.innerWidth();
            ccinputEl.css('width',ccinputElWidth+'px');
            ccinputEl.css('opacity',0);
            ccinputPosLeft = ccinputWidth-5-ccinputElWidth;
            ccinputEl.css('left', ccinputPosLeft+'px');
            $(this).on("focus", function() {
                $('.ccinput-counter',$(this).parent()).css('visibility','visible');
            });
            $(this).on("blur", function() {
                $('.ccinput-counter',$(this).parent()).css('visibility','hidden');
            });
            $(this).on("keypress", function() {
                countString($(this));
            });
            function countString(src) {
                var chars = src.val().length;
                if (chars > limit) {
                    src.val(src.val().substr(0, limit));
                    chars = limit;
                }
                ccinputPercent = parseFloat((chars / limit));
                ccinputPercent = ccinputPercent.toFixed(2);
                ccinputEl.css('opacity',ccinputPercent);
                $('.ccinput-counter', src.parent()).text(limit - chars);
            }
        }
    });
})(jQuery);