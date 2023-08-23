package me.gaegul.refactoring.ch10.no5.convertion;

/**
 * 전력이 필요한 현장에 인프라 설치 서비스 고객 속성 확인
 */
public class CustomerOfInfraService {

	public String client1(final Site rawSite) {
		final Site site = enrichSite(rawSite);
		final Customer aCustomer = rawSite.customer();
		String customerName;
		if (isUnknown(aCustomer)) {
			customerName = "거주자";
		} else {
			customerName = aCustomer.name();
		}
		return customerName;
	}

	public BillingPlan client2(final Customer aCustomer) {
		return isUnknown(aCustomer) ? BillingPlan.BASIC : aCustomer.billingPlan();
	}

	public int client3(final Customer aCustomer) {
		return isUnknown(aCustomer) ? 0 : aCustomer.paymentHistory().weeksDelinquentInLastYear();
	}

	private boolean isUnknown(final Customer aCustomer) {
		return aCustomer.sameName("미확인 고객");
	}

	private Site enrichSite(final Site rawSite) {
		return (Site) rawSite.clone();
	}
}
