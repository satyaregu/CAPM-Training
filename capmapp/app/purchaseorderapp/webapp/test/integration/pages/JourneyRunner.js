sap.ui.define([
    "sap/fe/test/JourneyRunner",
	"com/satya/purchaseorderapp/test/integration/pages/POsList",
	"com/satya/purchaseorderapp/test/integration/pages/POsObjectPage",
	"com/satya/purchaseorderapp/test/integration/pages/POItemsObjectPage"
], function (JourneyRunner, POsList, POsObjectPage, POItemsObjectPage) {
    'use strict';

    var runner = new JourneyRunner({
        launchUrl: sap.ui.require.toUrl('com/satya/purchaseorderapp') + '/test/flp.html#app-preview',
        pages: {
			onThePOsList: POsList,
			onThePOsObjectPage: POsObjectPage,
			onThePOItemsObjectPage: POItemsObjectPage
        },
        async: true
    });

    return runner;
});

