package me.gaegul.refactoring.ch10.no5.literal;

/**
 * 전력이 필요한 현장에 인프라 설치 서비스 고객 속성 확인
 */
public class CustomerOfInfraService {

	public String client1(final Site site) {
		return site.customer().name();
	}

	public BillingPlan client2(final Customer aCustomer) {
		return aCustomer.billingPlan();
	}

	public int client3(final Customer aCustomer) {
		return aCustomer.paymentHistory().weeksDelinquentInLastYear();
	}

}
