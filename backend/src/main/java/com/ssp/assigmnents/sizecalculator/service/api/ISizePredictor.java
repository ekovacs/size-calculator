package com.ssp.assigmnents.sizecalculator.service.api;

import com.ssp.assigmnents.sizecalculator.domain.Prediction;


public interface ISizePredictor {
	
	Prediction predictSize();
	
	abstract class Builder {
		public abstract ISizePredictor build();
	}
	
}
