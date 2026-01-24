//Creating Custom Service Implementation
//Its like DPC Class. This is the implementation for MyService

module.exports = (srv) => {

    //Implementing the function: display
    srv.on('display', req => `Hello ${req.data.name}`);
}