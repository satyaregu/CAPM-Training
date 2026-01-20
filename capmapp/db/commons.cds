namespace satyadb.commons;

//Custom Type or Data Element
type Guid : String(32);

//Aspect or Structure to hold address data
aspect address {
    HOUSENO : Int16;
    STREET  : String(32);
    CITY    : String(80);
    COUNTRY : String(3);
}
