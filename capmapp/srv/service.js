const SELECT = require("@sap/cds/lib/ql/SELECT");

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

    //Generic Handler - developer get flexibility to attach their own code on top of what CAPM already offers
    //implementing the Generic Handler: BEFORE for StudentSet on CREATE and PATCH operation
    this.before(['CREATE', 'PATCH'], StudentSet, (req) => {
        if (req.data.ID >= 10) {
            req.error(500, "You cannot create Student with ID more than 10");
        }
    });

    //implementing the Generic Handler: ON for StudentSet on READ operation
    //It means we are replacing the standard READ method logic
    this.on('READ', StudentSet, async (req) => {

        //Start a Database Transaction to write CDS Query Language
        const tx = await cds.tx(req);

        //Getting where condition from the payload
        var whereCondition = req.data;

        if (whereCondition.hasOwnProperty("ID")){
            //Reading the data based on the payload where condition
            return await tx.run(SELECT .from(StudentSet).where(whereCondition))
        }else{
            //Reading the data based hard coded where condition
            return await tx.run(SELECT .from(StudentSet).where({
                "GENDER" : 'F'
            }));
        }

        // //Reading all the data from the student table
        // var result = await tx.run(SELECT.from(StudentSet).limit(2));

        // //Updating the data
        // for (let i = 0; i < result.length; i++) {
        //     const element = result[i];
        //     //Updating the NAME field value
        //     element.NAME = 'Updated Name';

        // }
        // //Returning the data for READ operation
        // return result;

    });
});