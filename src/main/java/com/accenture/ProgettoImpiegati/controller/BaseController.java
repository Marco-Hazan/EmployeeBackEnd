package com.accenture.ProgettoImpiegati.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {

	protected static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
    /*
    protected ModelAndView redirectToErrorPageWithMessage(String errorMessage) {
        ModelAndView modelAndView = new ModelAndView(WebConstants.CNST_ERROR_PAGE);
        modelAndView.addObject(WebConstants.CNST_ERROR_MESSAGE, errorMessage);
        return modelAndView;
    }
    */



}