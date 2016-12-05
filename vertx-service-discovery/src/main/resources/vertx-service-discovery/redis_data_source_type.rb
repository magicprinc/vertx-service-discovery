require 'vertx-service-discovery/service_reference'
require 'vertx-redis/redis_client'
require 'vertx/util/utils.rb'
# Generated from io.vertx.servicediscovery.types.RedisDataSourceType
module VertxServiceDiscovery
  #  TODO
  class RedisDataSourceType
    # @private
    # @param j_del [::VertxServiceDiscovery::RedisDataSourceType] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxServiceDiscovery::RedisDataSourceType] the underlying java delegate
    def j_del
      @j_del
    end
    @@j_api_type = Object.new
    def @@j_api_type.accept?(obj)
      obj.class == RedisDataSourceType
    end
    def @@j_api_type.wrap(obj)
      RedisDataSourceType.new(obj)
    end
    def @@j_api_type.unwrap(obj)
      obj.j_del
    end
    def self.j_api_type
      @@j_api_type
    end
    def self.j_class
      Java::IoVertxServicediscoveryTypes::RedisDataSourceType.java_class
    end
    # @param [::VertxServiceDiscovery::ServiceReference] ref 
    # @return [::VertxRedis::RedisClient]
    def get_service(ref=nil)
      if ref.class.method_defined?(:j_del) && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:getService, [Java::IoVertxServicediscovery::ServiceReference.java_class]).call(ref.j_del),::VertxRedis::RedisClient)
      end
      raise ArgumentError, "Invalid arguments when calling get_service(#{ref})"
    end
    # @param [::VertxServiceDiscovery::ServiceReference] ref 
    # @return [::VertxRedis::RedisClient]
    def cached_service(ref=nil)
      if ref.class.method_defined?(:j_del) && !block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:cachedService, [Java::IoVertxServicediscovery::ServiceReference.java_class]).call(ref.j_del),::VertxRedis::RedisClient)
      end
      raise ArgumentError, "Invalid arguments when calling cached_service(#{ref})"
    end
  end
end
