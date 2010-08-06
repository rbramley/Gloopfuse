package loopfuse.tracking

import org.codehaus.groovy.grails.commons.ConfigurationHolder

/**
 * Taglib for LoopFuse tracking.
 * @author Robin Bramley
 */
class LoopfuseTrackingTagLib {
    static namespace = "lf"

    def trackPageview = {
		if (isEnabled()) {
            out << """
<script src="http://lfov.net/webrecorder/js/listen.js" type="text/Javascript"></script>
<script type="text/javascript">
_lf_cid = "\"LF_${getLoopfuseCID()}\"";
_lf_remora();
</script>"""
        }
    }

    private isEnabled() {
        def enabled = ConfigurationHolder.config.loopfuse.tracking.enabled
        
        // disable LoopFuse analytics if web property id is not defined 
        if (!getLoopfuseCID()) {
            enabled = false
        } else if (!(enabled instanceof Boolean)) {
            enabled = false
        }

        return enabled
    }

    private getLoopfuseCID() {
        return ConfigurationHolder.config.loopfuse.tracking.cid
    }

}
