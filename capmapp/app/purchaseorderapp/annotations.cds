using CatalogService as service from '../../srv/CatalogService';

//Creating Value Help for Company Name field
@cds.odata.valuelist
annotate service.BusinessPartnerSet with @(UI.Identification: [{
    $Type: 'UI.DataField',
    Value: COMPANY_NAME,
}]);

//Creating Value Help for Description Field
@cds.odata.valuelist
annotate service.ProductSet with @(UI.Identification: [{
    $Type: 'UI.DataField',
    Value: DESCRIPTION
}]);

//Linking the Company Name Value Help to PARTNER_GUID field
annotate service.POs with {
    PARTNER_GUID @(
        Common.Text            : PARTNER_GUID.COMPANY_NAME,
        Common.ValueList.entity: service.BusinessPartnerSet
    );
};

//Linking the Description Value Help with PRODUCT_GUID field
annotate service.POItems with {
    PRODUCT_GUID @(
        Common.Text            : PRODUCT_GUID.DESCRIPTION,
        Common.ValueList.entity: service.ProductSet
    );
};
