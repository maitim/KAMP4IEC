/**
 */
package edu.kit.ipd.sdq.kamp4iec.model.IECRepository.provider;

import edu.kit.ipd.sdq.kamp4iec.model.IECRepository.util.IECRepositoryAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IECRepositoryItemProviderAdapterFactory extends IECRepositoryAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IECRepositoryItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.FunctionBlock} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBlockItemProvider functionBlockItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.FunctionBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionBlockAdapter() {
		if (functionBlockItemProvider == null) {
			functionBlockItemProvider = new FunctionBlockItemProvider(this);
		}

		return functionBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.GlobalVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalVariableItemProvider globalVariableItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.GlobalVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGlobalVariableAdapter() {
		if (globalVariableItemProvider == null) {
			globalVariableItemProvider = new GlobalVariableItemProvider(this);
		}

		return globalVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECInterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECInterfaceItemProvider iecInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIECInterfaceAdapter() {
		if (iecInterfaceItemProvider == null) {
			iecInterfaceItemProvider = new IECInterfaceItemProvider(this);
		}

		return iecInterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Function} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionItemProvider functionItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionAdapter() {
		if (functionItemProvider == null) {
			functionItemProvider = new FunctionItemProvider(this);
		}

		return functionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Program} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramItemProvider programItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Program}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProgramAdapter() {
		if (programItemProvider == null) {
			programItemProvider = new ProgramItemProvider(this);
		}

		return programItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Repository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryItemProvider repositoryItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Repository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRepositoryAdapter() {
		if (repositoryItemProvider == null) {
			repositoryItemProvider = new RepositoryItemProvider(this);
		}

		return repositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECPropertyItemProvider iecPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIECPropertyAdapter() {
		if (iecPropertyItemProvider == null) {
			iecPropertyItemProvider = new IECPropertyItemProvider(this);
		}

		return iecPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECAbstractProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECAbstractPropertyItemProvider iecAbstractPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECAbstractProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIECAbstractPropertyAdapter() {
		if (iecAbstractPropertyItemProvider == null) {
			iecAbstractPropertyItemProvider = new IECAbstractPropertyItemProvider(this);
		}

		return iecAbstractPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECAbstractMethod} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECAbstractMethodItemProvider iecAbstractMethodItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECAbstractMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIECAbstractMethodAdapter() {
		if (iecAbstractMethodItemProvider == null) {
			iecAbstractMethodItemProvider = new IECAbstractMethodItemProvider(this);
		}

		return iecAbstractMethodItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECMethod} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IECMethodItemProvider iecMethodItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.IECMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIECMethodAdapter() {
		if (iecMethodItemProvider == null) {
			iecMethodItemProvider = new IECMethodItemProvider(this);
		}

		return iecMethodItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Enum} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumItemProvider enumItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.Enum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnumAdapter() {
		if (enumItemProvider == null) {
			enumItemProvider = new EnumItemProvider(this);
		}

		return enumItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.ImplementsInterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementsInterfaceItemProvider implementsInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link edu.kit.ipd.sdq.kamp4iec.model.IECRepository.ImplementsInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImplementsInterfaceAdapter() {
		if (implementsInterfaceItemProvider == null) {
			implementsInterfaceItemProvider = new ImplementsInterfaceItemProvider(this);
		}

		return implementsInterfaceItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (functionBlockItemProvider != null) functionBlockItemProvider.dispose();
		if (globalVariableItemProvider != null) globalVariableItemProvider.dispose();
		if (iecInterfaceItemProvider != null) iecInterfaceItemProvider.dispose();
		if (iecMethodItemProvider != null) iecMethodItemProvider.dispose();
		if (functionItemProvider != null) functionItemProvider.dispose();
		if (programItemProvider != null) programItemProvider.dispose();
		if (repositoryItemProvider != null) repositoryItemProvider.dispose();
		if (iecPropertyItemProvider != null) iecPropertyItemProvider.dispose();
		if (iecAbstractPropertyItemProvider != null) iecAbstractPropertyItemProvider.dispose();
		if (iecAbstractMethodItemProvider != null) iecAbstractMethodItemProvider.dispose();
		if (enumItemProvider != null) enumItemProvider.dispose();
		if (implementsInterfaceItemProvider != null) implementsInterfaceItemProvider.dispose();
	}

}
