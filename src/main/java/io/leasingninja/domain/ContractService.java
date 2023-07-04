package io.leasingninja.domain;

import java.time.LocalDate;

public class ContractService {

    public static void calculateInstallmentFor(Contract contract, int leaseTermInMonths, double interestInPercentPerYear) {
		double inAdvance = 0;
		double residualValue = 0;

		double interestPerMonth = interestInPercentPerYear / 12;

		double pmt = pmt(
			leaseTermInMonths,
			interestPerMonth,
			-1 * contract.getPrice(),
			residualValue,
			inAdvance);

		// reduce to two digits after the dot
		pmt = ((double) Math.round(pmt * 100)) / 100;

		contract.setInstallment(pmt);

		//.currency());
	}

    private static double pmt(double n, double iInPercent, double pv, double fv, double s) {
		double i = iInPercent / 100;

        if (i == 0) {
            return (-1 * pv - fv) / n;
        }

		return (i * ( fv + pv * Math.pow(1 + i, n))) / ((1 + i * s) * (1 - Math.pow(1 + i, n)));
	}

    public static void signContract(Contract contract, LocalDate date) {
       contract.setSignDate(date);
    }

	public void checkCreditRating(Contract contract, int creditRating) {
		if(creditRating >= 1 && creditRating <= 10) {
			contract.setCreditRating(creditRating);
		}
	}

	/**
	 * @param votingResult An integer with the following allowed values:
	 * 					   1 = accepted,
	 * 					   2 = accepted with obligations,
	 * 					   0 = rejected
	 */
    public static void voteContract(Contract contract, int votingResult) {
		if(votingResult >= 0 && votingResult <= 2) {
			contract.setVotingResult(votingResult);
		}
	 }

 }
