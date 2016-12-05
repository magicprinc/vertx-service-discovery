/*
 * Copyright (c) 2011-2016 The original author or authors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *      The Eclipse Public License is available at
 *      http://www.eclipse.org/legal/epl-v10.html
 *
 *      The Apache License v2.0 is available at
 *      http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.servicediscovery.types;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.Record;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.servicediscovery.impl.ServiceTypes;
import io.vertx.servicediscovery.types.impl.HttpEndpointImpl;
import io.vertx.servicediscovery.types.impl.JDBCDataSourceImpl;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
@VertxGen
public interface JDBCDataSource extends JDBCDataSourceType {

  String TYPE = "jdbc";

  static JDBCDataSourceType serviceType() {
    return (JDBCDataSourceType) ServiceTypes.get(TYPE);
  }

  static Record createRecord(String name, JsonObject location, JsonObject metadata) {
    Objects.requireNonNull(name);
    Objects.requireNonNull(location);

    Record record = new Record().setName(name)
        .setType(TYPE)
        .setLocation(location);

    if (metadata != null) {
      record.setMetadata(metadata);
    }

    return record;
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured {@link io.vertx.ext.jdbc.JDBCClient}. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   *
   * @param discovery     The service discovery instance
   * @param filter        The filter, optional
   * @param resultHandler The result handler
   */
  static void getJDBCClient(ServiceDiscovery discovery, JsonObject filter,
                            Handler<AsyncResult<JDBCClient>> resultHandler) {
    discovery.getRecord(filter, ar -> {
      if (ar.failed() || ar.result() == null) {
        resultHandler.handle(Future.failedFuture("No matching record"));
      } else {
        resultHandler.handle(Future.succeededFuture(discovery.<JDBCClient>getReference(ar.result()).get()));
      }
    });
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured {@link io.vertx.ext.jdbc.JDBCClient}. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   *
   * @param discovery     The service discovery instance
   * @param filter        The filter (must not be {@code null})
   * @param resultHandler The result handler
   */
  static void getJDBCClient(ServiceDiscovery discovery, Function<Record, Boolean> filter,
                            Handler<AsyncResult<JDBCClient>> resultHandler) {
    discovery.getRecord(filter, ar -> {
      if (ar.failed() || ar.result() == null) {
        resultHandler.handle(Future.failedFuture("No matching record"));
      } else {
        resultHandler.handle(Future.succeededFuture(discovery.<JDBCClient>getReference(ar.result()).get()));
      }
    });
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured {@link io.vertx.ext.jdbc.JDBCClient}. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   *
   * @param discovery             The service discovery instance
   * @param filter                The filter, optional
   * @param consumerConfiguration the consumer configuration
   * @param resultHandler         the result handler
   */
  static void getJDBCClient(ServiceDiscovery discovery, JsonObject filter, JsonObject consumerConfiguration,
                            Handler<AsyncResult<JDBCClient>> resultHandler) {
    discovery.getRecord(filter, ar -> {
      if (ar.failed() || ar.result() == null) {
        resultHandler.handle(Future.failedFuture("No matching record"));
      } else {
        resultHandler.handle(Future.succeededFuture(
            discovery.<JDBCClient>getReferenceWithConfiguration(ar.result(), consumerConfiguration).get()));
      }
    });
  }

  /**
   * Convenient method that looks for a JDBC datasource source and provides the configured {@link io.vertx.ext.jdbc.JDBCClient}. The
   * async result is marked as failed is there are no matching services, or if the lookup fails.
   *
   * @param discovery             The service discovery instance
   * @param filter                The filter, must not be {@code null}
   * @param consumerConfiguration the consumer configuration
   * @param resultHandler         the result handler
   */
  static void getJDBCClient(ServiceDiscovery discovery, Function<Record, Boolean> filter, JsonObject consumerConfiguration,
                            Handler<AsyncResult<JDBCClient>> resultHandler) {
    discovery.getRecord(filter, ar -> {
      if (ar.failed() || ar.result() == null) {
        resultHandler.handle(Future.failedFuture("No matching record"));
      } else {
        resultHandler.handle(Future.succeededFuture(
          discovery.<JDBCClient>getReferenceWithConfiguration(ar.result(), consumerConfiguration).get()));
      }
    });
  }
}


