//Implementation of the CatalogService
module.exports = cds.service.impl(async function() {

    //implementing the boost action of the POs entity set
    this.on('boot', async(req) => {
        console.log('boot bound action is called');
        return{
            "NODE_KEY" : "Dummy"
        };
    });
});