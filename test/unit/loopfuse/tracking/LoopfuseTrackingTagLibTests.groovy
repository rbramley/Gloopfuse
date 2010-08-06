package loopfuse.tracking

import grails.test.*

/**
 * Test that the taglib behaves sensibly...
 * @author Robin Bramley
 */
class LoopfuseTrackingTagLibTests extends TagLibUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testTaglibEnabled() {
        mockConfig '''
            loopfuse.tracking.enabled = true
            loopfuse.tracking.cid = "deadbeef"
        '''

    	def out = new StringWriter()
    	tagLib.metaClass.out = out

    	tagLib.trackPageview()
    	assertTrue out.toString().contains('deadbeef')
    }

    void testTaglibDisabled() {
        mockConfig '''
            loopfuse.tracking.enabled = false
            loopfuse.tracking.cid = "deadbeef"
        '''

    	def out = new StringWriter()
    	tagLib.metaClass.out = out

    	tagLib.trackPageview()
    	assertTrue out.toString().size() == 0
    }

    void testTaglibMissingConfig() {
        mockConfig '''
            foo = bar
        '''

    	def out = new StringWriter()
    	tagLib.metaClass.out = out

    	tagLib.trackPageview()
    	assertTrue out.toString().size() == 0
    }

    void testTaglibMissingEnabled() {
        mockConfig '''
            loopfuse.tracking.cid = "deadbeef"
        '''

    	def out = new StringWriter()
    	tagLib.metaClass.out = out

    	tagLib.trackPageview()
    	assertTrue out.toString().size() == 0
    }

}
