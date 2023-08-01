package me.gaegul.refactoring.ch09.change_value_to_reference;

public class CustomerRepository {
	private static final RepositoryData repositoryData;

	static {
		repositoryData = new RepositoryData();
	}
	public static Customer registerCustomer(final Long id) {
		if (!repositoryData.customers().containsKey(id)) {
			repositoryData.customers().put(id, new Customer(id));
		}
		return findCustomer(id);
	}

	public static Customer findCustomer(final Long id) {
		return repositoryData.customers().get(id);
	}

}
