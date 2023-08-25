package me.gaegul.refactoring.ch10.no5.convertion;

/**
 * 전력이 필요한 현장에 인프라 설치 서비스 고객 속성 확인
 */
public class CustomerOfInfraService {

	public String client1(final Site rawSite) {
		final Site site = enrichSite(rawSite);
		final Customer aCustomer = site.customer();
		return aCustomer.name();
	}

	public BillingPlan client2(final Site rawSite) {
		return enrichSite(rawSite).customer().billingPlan();
	}

	public int client3(final Site rawSite) {
		return enrichSite(rawSite).customer().paymentHistory().weeksDelinquentInLastYear();
	}

	private boolean isUnknown(final Customer aCustomer) {
		return aCustomer.sameName("미확인 고객");
	}

	private Site enrichSite(final Site rawSite) {
		final Site result = (Site) rawSite.clone();
		final Customer unknownCustomer = new Customer("거주자", BillingPlan.BASIC, 0, true);
		if (isUnknown(result.customer())) {
			result.setCustomer(unknownCustomer);
		} else {
			result.customer().setUnknown(false);
		}
		return result;
	}
}
