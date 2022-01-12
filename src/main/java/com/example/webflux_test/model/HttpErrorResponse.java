package com.example.webflux_test.model;/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2020
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/

import com.example.webflux_test.common.ProblemDetails;
import org.springframework.http.HttpStatus;

public class HttpErrorResponse {
  private HttpStatus httpStatus;
  private String internalCode;
  private ProblemDetails problemDetails;

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public String getInternalCode() {
    return internalCode;
  }

  public void setInternalCode(String internalCode) {
    this.internalCode = internalCode;
  }

  public ProblemDetails getProblemDetails() {
    return problemDetails;
  }

  public void setProblemDetails(ProblemDetails problemDetails) {
    this.problemDetails = problemDetails;
  }
}
