
//implementing the service service
module.exports = cds.service.impl(async function () {

    //Getting the student set data
    const { StudentSet } = this.entities;

    //implementing the custom action of the Student Entity Set
    this.on('CustomAction', async (req) => {
        console.log('Custom Action is Called');

        try {

            //Getting the importing value of the action
            const ID = req.params[0];

            //Start a Database Transaction to write CDS Query Language
            const tx = cds.tx(req);

            //CDS Query Language - communicate to Database in agnostic manner
            //Means we are writing database independt SQL Queries

            //Updating StudentSet
            await tx.update(StudentSet).with({
                "CITY": "Chennai"
            }).where(ID);

        } catch (error) {
            return "Error " + error.toString();
        }
    });

    //implementing the custom function of the student entity set
    this.on('CustomFunction', async (req) => {
        console.log('Custom Function is called');

        try {

            //Start a new Database Transaction to write CDS Query Launguage
            const tx = cds.tx(req);

            //Read the last student id record by desending order
            const studentData = tx.read(StudentSet).orderBy({
                ID: 'desc'
            }).limit(1);

            return studentData;

        } catch (error) {
            return "Error " + error.toString();
        }
    });
});