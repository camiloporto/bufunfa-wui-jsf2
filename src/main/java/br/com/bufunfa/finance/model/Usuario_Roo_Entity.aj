package br.com.bufunfa.finance.model;

import br.com.bufunfa.finance.model.Usuario;
import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Usuario_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Usuario.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Usuario.id;
    
    @Version
    @Column(name = "version")
    private Integer Usuario.version;
    
    public Long Usuario.getId() {
        return this.id;
    }
    
    public void Usuario.setId(Long id) {
        this.id = id;
    }
    
    public Integer Usuario.getVersion() {
        return this.version;
    }
    
    public void Usuario.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Usuario.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Usuario.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Usuario attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Usuario.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public Usuario Usuario.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Usuario merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Usuario.entityManager() {
        EntityManager em = new Usuario().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Usuario.countUsuarios() {
        return ((Number) entityManager().createQuery("select count(o) from Usuario o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Usuario> Usuario.findAllUsuarios() {
        return entityManager().createQuery("select o from Usuario o").getResultList();
    }
    
    public static Usuario Usuario.findUsuario(Long id) {
        if (id == null) return null;
        return entityManager().find(Usuario.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Usuario> Usuario.findUsuarioEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Usuario o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
