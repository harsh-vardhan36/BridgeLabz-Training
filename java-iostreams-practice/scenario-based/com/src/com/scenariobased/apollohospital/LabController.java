package com.scenariobased.apollohospital;

	public class LabController {

	    @PublicAPI(description = "Get blood test results")
	    public void getBloodTest() {}

	    @RequiresAuth(role = "DOCTOR")
	    public void uploadReport() {}

	    public void deleteReport() {}  
	}

}
