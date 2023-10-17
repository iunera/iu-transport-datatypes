package com.iunera.publictransport.domain;

/**
 * 
 */
public enum EStopType {
  START, END,
  /** an end stop of a line that is also the start of a new line or the same line restarting */
  STARTEND,
  /** a normal stop */
  NORMAL,
  /** not a stop */
  NOSTOP

}
