package br.com.bufunfa.finance.model;

import br.com.bufunfa.finance.model.UsuarioDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect UsuarioIntegrationTest_Roo_IntegrationTest {
    
    declare @type: UsuarioIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: UsuarioIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private UsuarioDataOnDemand UsuarioIntegrationTest.dod;
    
    @Test
    public void UsuarioIntegrationTest.testCountUsuarios() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        long count = br.com.bufunfa.finance.model.Usuario.countUsuarios();
        org.junit.Assert.assertTrue("Counter for 'Usuario' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void UsuarioIntegrationTest.testFindUsuario() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        java.lang.Long id = dod.getRandomUsuario().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to provide an identifier", id);
        br.com.bufunfa.finance.model.Usuario obj = br.com.bufunfa.finance.model.Usuario.findUsuario(id);
        org.junit.Assert.assertNotNull("Find method for 'Usuario' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Usuario' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void UsuarioIntegrationTest.testFindAllUsuarios() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        long count = br.com.bufunfa.finance.model.Usuario.countUsuarios();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'Usuario', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<br.com.bufunfa.finance.model.Usuario> result = br.com.bufunfa.finance.model.Usuario.findAllUsuarios();
        org.junit.Assert.assertNotNull("Find all method for 'Usuario' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'Usuario' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void UsuarioIntegrationTest.testFindUsuarioEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        long count = br.com.bufunfa.finance.model.Usuario.countUsuarios();
        if (count > 20) count = 20;
        java.util.List<br.com.bufunfa.finance.model.Usuario> result = br.com.bufunfa.finance.model.Usuario.findUsuarioEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'Usuario' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'Usuario' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void UsuarioIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        java.lang.Long id = dod.getRandomUsuario().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to provide an identifier", id);
        br.com.bufunfa.finance.model.Usuario obj = br.com.bufunfa.finance.model.Usuario.findUsuario(id);
        org.junit.Assert.assertNotNull("Find method for 'Usuario' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyUsuario(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Usuario' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void UsuarioIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        java.lang.Long id = dod.getRandomUsuario().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to provide an identifier", id);
        br.com.bufunfa.finance.model.Usuario obj = br.com.bufunfa.finance.model.Usuario.findUsuario(id);
        org.junit.Assert.assertNotNull("Find method for 'Usuario' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyUsuario(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Usuario' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void UsuarioIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        br.com.bufunfa.finance.model.Usuario obj = dod.getNewTransientUsuario(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Usuario' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Usuario' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void UsuarioIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to initialize correctly", dod.getRandomUsuario());
        java.lang.Long id = dod.getRandomUsuario().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Usuario' failed to provide an identifier", id);
        br.com.bufunfa.finance.model.Usuario obj = br.com.bufunfa.finance.model.Usuario.findUsuario(id);
        org.junit.Assert.assertNotNull("Find method for 'Usuario' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Usuario' with identifier '" + id + "'", br.com.bufunfa.finance.model.Usuario.findUsuario(id));
    }
    
}
