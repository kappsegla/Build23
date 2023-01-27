package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
public class RedisInDockerExampleIT {
    private RedisBackedCache underTest;

    @Container
    GenericContainer<?> redis =
            new GenericContainer<>(DockerImageName.parse("redis:7-alpine"))
            .withExposedPorts(6379);

    @BeforeEach
    public void setUp() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();
        // Now we have an address and port for Redis, no matter where it is running
        underTest = new RedisBackedCache(address, port);
    }

    @AfterEach
    void tearDown() {
        underTest.close();
    }

    @Test
    //@Disabled("Code is not implemented yet")
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        assertThat(retrieved).isEqualTo("example");
    }
}
