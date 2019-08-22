package com.newegg.ec.redis.util;

import com.newegg.ec.redis.entity.Machine;
import com.newegg.ec.redis.plugin.install.service.impl.DockerInstallationOperation;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SSH2UtilTest {

    Machine machine = new Machine();

    int port = 8000;

    @Before
    public void buildMachine() {
        machine.setHost("");
        machine.setUserName("root");
        machine.setPassword("");
    }

    @Test
    public void scp() throws Exception {
        SSH2Util.scp(machine, "E:\\redis.conf", "/data/");
    }

    @Test
    public void cp() throws Exception {
        SSH2Util.copy(machine, "/home/hadoop/jay/redis.conf", DockerInstallationOperation.DOCKER_INSTALL_BASE_PATH + port, true);
    }

    @Test
    public void createFile() throws Exception {
        SSH2Util.createFile(machine, "/data/", true);
    }

    @Test
    public void mkdir() throws Exception {
        SSH2Util.mkdir(machine, DockerInstallationOperation.DOCKER_INSTALL_BASE_PATH + port, false);
    }

    @Test
    public void rm() throws Exception {
        SSH2Util.rm(machine, DockerInstallationOperation.DOCKER_INSTALL_BASE_PATH + port, true);
    }
}