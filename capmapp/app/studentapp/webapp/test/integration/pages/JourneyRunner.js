sap.ui.define([
    "sap/fe/test/JourneyRunner",
	"com/satya/studentapp/test/integration/pages/StudentSetList",
	"com/satya/studentapp/test/integration/pages/StudentSetObjectPage"
], function (JourneyRunner, StudentSetList, StudentSetObjectPage) {
    'use strict';

    var runner = new JourneyRunner({
        launchUrl: sap.ui.require.toUrl('com/satya/studentapp') + '/test/flp.html#app-preview',
        pages: {
			onTheStudentSetList: StudentSetList,
			onTheStudentSetObjectPage: StudentSetObjectPage
        },
        async: true
    });

    return runner;
});

