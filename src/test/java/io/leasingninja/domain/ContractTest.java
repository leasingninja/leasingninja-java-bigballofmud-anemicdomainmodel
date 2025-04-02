package io.leasingninja.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContractTest {

    @Test
	void givenAFilledOutContract_whenCalculate_thenInstallmentIsX() {
		// given
		Contract contract = new Contract();
        contract.setNumber("4711");
		contract.setLessee("John Buyer");
		contract.setCar("Volkswagen ID.3");
		contract.setPrice(40_000);
        //contract.setCurrency("EUR"));

		// when
    	ContractService.calculateInstallmentFor(contract, 48, 3.7);

		// then
		assertThat(contract.getInstallment()).isEqualTo(897.80);
	}

	@Test
	void givenAFilledOutContractWith0Interest_whenCalculate_thenInstallmentIsX() {
		// given
		Contract contract = new Contract();
        contract.setNumber("4711");
		contract.setLessee("John Buyer");
		contract.setCar("Volkswagen ID.3");
		contract.setPrice(40_000);
        //contract.setCurrency("EUR"));

		// when
    	ContractService.calculateInstallmentFor(contract, 48, 0);

		// then
		assertThat(contract.getInstallment()).isEqualTo(833.33);
	}

    // no givenACalculatedContract_whenSign_thenContractIsSigned() since we just call setSignDate()

}
