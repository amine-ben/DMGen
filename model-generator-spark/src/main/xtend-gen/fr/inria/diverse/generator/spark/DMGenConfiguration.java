package fr.inria.diverse.generator.spark;

import org.apache.commons.lang3.Range;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("all")
public interface DMGenConfiguration {
  /**
   * returns  the range of number of references tp be created for an EClass
   * @param the <code>eClass</code> for which we compute the range
   */
  public abstract Range<Integer> getRangeFor(final EClass eCLass);
  
  /**
   * returns  the range of number of references tp be created for an EClass
   * @param the <code>eAttribute</code> for which we compute the range
   */
  public abstract Range<Integer> getRangeFor(final EAttribute eAttribute);
  
  /**
   * returns  the range of number of references tp be created for an EClass
   * @param the <code>eReference</code> for which we compute the range
   */
  public abstract Range<Integer> getRangeFor(final EReference eReference);
}
