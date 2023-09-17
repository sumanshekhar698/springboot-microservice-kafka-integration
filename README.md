# springboot-microservice-kafka-integration

```powershell
# Start the ZooKeeper service
PS C:\> cd .\kafka_2.13-3.5.0\
PS C:\kafka_2.13-3.5.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

```powershell
# Start the Kafka broker service
PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-server-start.bat .\config\server.properties
```

## Producing a Topic

1. Create a topic with **kafka-topics**
2. Produce example message with **kafka-console-producer**
3. Consume the message with **kafka-console-consumer**

### Creating a topic

```powershell
PowerShell 7.3.6
PS C:\Users\suman> cd C:\kafka_2.13-3.5.0\
PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-topics.bat
Create, delete, describe, or change a topic.
Option                                   Description
------                                   -----------
--alter                                  Alter the number of partitions and
                                           replica assignment. Update the
                                           configuration of an existing topic
                                           via --alter is no longer supported
                                           here (the kafka-configs CLI supports
                                           altering topic configs with a --
                                           bootstrap-server option).
--at-min-isr-partitions                  if set when describing topics, only
                                           show partitions whose isr count is
                                           equal to the configured minimum.
--bootstrap-server <String: server to    REQUIRED: The Kafka server to connect
  connect to>                              to.
--command-config <String: command        Property file containing configs to be
  config property file>                    passed to Admin Client. This is used
                                           only with --bootstrap-server option
                                           for describing and altering broker
                                           configs.
--config <String: name=value>            A topic configuration override for the
                                           topic being created or altered. The
                                           following is a list of valid
                                           configurations:
                                                cleanup.policy
                                                compression.type
                                                delete.retention.ms
                                                file.delete.delay.ms
                                                flush.messages
                                                flush.ms
                                                follower.replication.throttled.
                                           replicas
                                                index.interval.bytes
                                                leader.replication.throttled.replicas
                                                local.retention.bytes
                                                local.retention.ms
                                                max.compaction.lag.ms
                                                max.message.bytes
                                                message.downconversion.enable
                                                message.format.version
                                                message.timestamp.difference.max.ms
                                                message.timestamp.type
                                                min.cleanable.dirty.ratio
                                                min.compaction.lag.ms
                                                min.insync.replicas
                                                preallocate
                                                remote.storage.enable
                                                retention.bytes
                                                retention.ms
                                                segment.bytes
                                                segment.index.bytes
                                                segment.jitter.ms
                                                segment.ms
                                                unclean.leader.election.enable
                                         See the Kafka documentation for full
                                           details on the topic configs. It is
                                           supported only in combination with --
                                           create if --bootstrap-server option
                                           is used (the kafka-configs CLI
                                           supports altering topic configs with
                                           a --bootstrap-server option).
--create                                 Create a new topic.
--delete                                 Delete a topic
--delete-config <String: name>           A topic configuration override to be
                                           removed for an existing topic (see
                                           the list of configurations under the
                                           --config option). Not supported with
                                           the --bootstrap-server option.
--describe                               List details for the given topics.
--exclude-internal                       exclude internal topics when running
                                           list or describe command. The
                                           internal topics will be listed by
                                           default
--help                                   Print usage information.
--if-exists                              if set when altering or deleting or
                                           describing topics, the action will
                                           only execute if the topic exists.
--if-not-exists                          if set when creating topics, the
                                           action will only execute if the
                                           topic does not already exist.
--list                                   List all available topics.
--partitions <Integer: # of partitions>  The number of partitions for the topic
                                           being created or altered (WARNING:
                                           If partitions are increased for a
                                           topic that has a key, the partition
                                           logic or ordering of the messages
                                           will be affected). If not supplied
                                           for create, defaults to the cluster
                                           default.
--replica-assignment <String:            A list of manual partition-to-broker
  broker_id_for_part1_replica1 :           assignments for the topic being
  broker_id_for_part1_replica2 ,           created or altered.
  broker_id_for_part2_replica1 :
  broker_id_for_part2_replica2 , ...>
--replication-factor <Integer:           The replication factor for each
  replication factor>                      partition in the topic being
                                           created. If not supplied, defaults
                                           to the cluster default.
--topic <String: topic>                  The topic to create, alter, describe
                                           or delete. It also accepts a regular
                                           expression, except for --create
                                           option. Put topic name in double
                                           quotes and use the '\' prefix to
                                           escape regular expression symbols; e.
                                           g. "test\.topic".
--topic-id <String: topic-id>            The topic-id to describe.This is used
                                           only with --bootstrap-server option
                                           for describing topics.
--topics-with-overrides                  if set when describing topics, only
                                           show topics that have overridden
                                           configs
--unavailable-partitions                 if set when describing topics, only
                                           show partitions whose leader is not
                                           available
--under-min-isr-partitions               if set when describing topics, only
                                           show partitions whose isr count is
                                           less than the configured minimum.
--under-replicated-partitions            if set when describing topics, only
                                           show under replicated partitions
--version                                Display Kafka version.
PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-topics.bat --version
**3.5.0**

PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-topics.bat --create --topic user-topic-1 --bootstrap-server localhost:9092
Created topic user-topic-1.

PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-topics.bat --describe --topic user-topic-1  --bootstrap-server localhost:9092
Topic: user-topic-1     TopicId: J3z7WaDwTP-xsgkrmyH_pg PartitionCount: 1       ReplicationFactor: 1    Configs:
        **Topic: user-topic-1     Partition: 0    Leader: 0       Replicas: 0     Isr: 0**
PS C:\kafka_2.13-3.5.0>
```

### Producing a message to the specific topic

```powershell
PowerShell 7.3.6
PS C:\Users\suman> cd C:\kafka_2.13-3.5.0\
PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-console-producer.bat --topic user-topic-1 --bootstrap-server localhost:9092
**>Hey
>I am producing message :)
>Hello
>I am bored
>**
```

### Consuming message from the topic

```powershell
PowerShell 7.3.6
PS C:\Users\suman> cd C:\kafka_2.13-3.5.0\
PS C:\kafka_2.13-3.5.0> .\bin\windows\kafka-console-consumer.bat --topic user-topic-1 --from-beginning --bootstrap-server localhost:9092
**Hey
I am producing message :)
Hello
I am bored**
```

Also make sure. your ZooKeeperand Kafka Server is up before runing these projects