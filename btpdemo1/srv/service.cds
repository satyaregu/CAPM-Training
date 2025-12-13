using { satya } from '../db/datamodel';

service btpdemoservice {

    entity InvoiceSet as projection on satya.supermarket_orders;
    
}
