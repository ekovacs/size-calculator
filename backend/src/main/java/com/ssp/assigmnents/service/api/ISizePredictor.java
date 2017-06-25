package com.ssp.assigmnents.service.api;

import com.ssp.assigmnents.domain.Prediction;


public interface ISizePredictor {
	
	Prediction predictSize();
	
	abstract class Builder {
		public abstract ISizePredictor build();
	}
	
}
