package me.gaegul.refactoring.ch10.no5;

/**
 * 전력이 필요한 현장에 인프라 설치 서비스 고객 속성 확인
 */
public class CustomerOfInfraService {

	public String client1(final Site site) {
		final Customer aCustomer = site.customer();
		String customerName;
		if (aCustomer.sameName("미확인 고객")) {
			customerName = "거주자";
		} else {
			customerName = aCustomer.name();
		}
		return customerName;
	}

	public BillingPlan client2(final Customer aCustomer) {
		return aCustomer.sameName("미확인 고객") ? BillingPlan.BASIC : aCustomer.billingPlan();
	}


	public int client3(final Customer aCustomer) {
		return aCustomer.sameName("미확인 고객") ? 0 : aCustomer.paymentHistory().weeksDelinquentInLastYear();
	}
}
