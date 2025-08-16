package methods;

import environment.DriverUtils;
import pages.CareersPage;
import pages.JobListPage;
import pages.JobPage;
import pages.LabcorpHomePage;

public interface BaseTest {
	
	CommonFunctions navigationObj = new CommonFunctions();
	LabcorpHomePage labCorpHome = new LabcorpHomePage();
	CareersPage career_page = new CareersPage();
	JobListPage job_list_page = new JobListPage();
	JobPage job_page = new JobPage();
	commonFunctions_API apiCommons = new commonFunctions_API();
	

}