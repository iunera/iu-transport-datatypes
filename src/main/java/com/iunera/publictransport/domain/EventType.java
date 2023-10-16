package com.iunera.publictransport.domain;

public enum EventType {
  /** An event that appears generally on the road */
  WAYPOINT,
  /** An event that appears during when the vehicle is halted */
  STOPEVENT,
  /**
   * An event that indicates an message - such a message can be an error or also a version of a
   * serial version of a system
   */
  MESSAGE

}
