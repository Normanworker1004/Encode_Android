// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecountsData.proto

// Protobuf Java Version: 3.25.1
package com.sweetwater.encore;

public interface RecountRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:RecountRequest)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>int32 recountRequestId = 1;</code>
   * @return The recountRequestId.
   */
  int getRecountRequestId();

  /**
   * <code>int32 priority = 2;</code>
   * @return The priority.
   */
  int getPriority();

  /**
   * <code>int32 requestedByEmployee = 3;</code>
   * @return The requestedByEmployee.
   */
  int getRequestedByEmployee();

  /**
   * <code>string requestedDate = 4;</code>
   * @return The requestedDate.
   */
  java.lang.String getRequestedDate();
  /**
   * <code>string requestedDate = 4;</code>
   * @return The bytes for requestedDate.
   */
  com.google.protobuf.ByteString
      getRequestedDateBytes();

  /**
   * <code>string requestedStatus = 5;</code>
   * @return The requestedStatus.
   */
  java.lang.String getRequestedStatus();
  /**
   * <code>string requestedStatus = 5;</code>
   * @return The bytes for requestedStatus.
   */
  com.google.protobuf.ByteString
      getRequestedStatusBytes();

  /**
   * <code>string completedAt = 6;</code>
   * @return The completedAt.
   */
  java.lang.String getCompletedAt();
  /**
   * <code>string completedAt = 6;</code>
   * @return The bytes for completedAt.
   */
  com.google.protobuf.ByteString
      getCompletedAtBytes();

  /**
   * <code>.RecountProduct product = 7;</code>
   * @return Whether the product field is set.
   */
  boolean hasProduct();
  /**
   * <code>.RecountProduct product = 7;</code>
   * @return The product.
   */
  com.sweetwater.encore.RecountProduct getProduct();
}
