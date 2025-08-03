package testcases.automationFun;

import org.testng.annotations.Test;

public class GroupExample {

	@Test(groups = "SmokeTest")
	public void method1() {
		System.out.println("Method1");
	}

	@Test(groups = {"SmokeTest","SanityTest"})
	public void method2() {
		System.out.println("Method2");
	}

	@Test(groups = "SmokeTest")
	public void method3() {
		System.out.println("Method3");
	}

	@Test(groups = {"SmokeTest","SanityTest"})
	public void method4() {
		System.out.println("Method4");
	}

	@Test(groups = "SanityTest")
	public void method5() {
		System.out.println("Method5");
	}
}
