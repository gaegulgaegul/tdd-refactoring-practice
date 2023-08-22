package me.gaegul.refactoring.ch10.no5;

/**
 * 전력이 필요한 현장에 인프라 설치 서비스
 */
public class InstallInfraService {

	public String client1(final Site site) {
		return site.customer().name();
	}

	public BillingPlan client2(final Customer aCustomer) {
		return aCustomer.billingPlan();
	}
	public void client3(final Customer aCustomer, final BillingPlan newPlan) {
		aCustomer.setBillingPlan(newPlan);
	}

	public int client4(final Customer aCustomer) {
		return aCustomer.paymentHistory().weeksDelinquentInLastYear();
	}

	public String client5(final Customer aCustomer) {
		return aCustomer.isUnknown() ? "미확인 거주자" : aCustomer.name();
	}
}
