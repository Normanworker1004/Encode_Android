// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecountsData.proto

// Protobuf Java Version: 3.25.1
package com.sweetwater.encore;

public interface RecountsDataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RecountsData)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>.RecountRequest currentRecountRequest = 1;</code>
   * @return Whether the currentRecountRequest field is set.
   */
  boolean hasCurrentRecountRequest();
  /**
   * <code>.RecountRequest currentRecountRequest = 1;</code>
   * @return The currentRecountRequest.
   */
  com.sweetwater.encore.RecountRequest getCurrentRecountRequest();

  /**
   * <code>repeated .RecountLocation currentRecountLocations = 2;</code>
   */
  java.util.List<com.sweetwater.encore.RecountLocation> 
      getCurrentRecountLocationsList();
  /**
   * <code>repeated .RecountLocation currentRecountLocations = 2;</code>
   */
  com.sweetwater.encore.RecountLocation getCurrentRecountLocations(int index);
  /**
   * <code>repeated .RecountLocation currentRecountLocations = 2;</code>
   */
  int getCurrentRecountLocationsCount();
}
