package test.unittest;

import net.tiaozhanbei.model.Project;
import net.tiaozhanbei.util.Page;

public class PageTest {

	public static void main(String[] args) {
		Page<Project> page = new Page<Project>("10");
		page.setTotalCount(11);

		page.setPage(1);
		System.out.println(page.getLinks("project"));
	}
}
