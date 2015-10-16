Ext.define('admin.store.Types', {
    extend: 'Ext.data.Store',
    alias : 'store.types',
    model: 'admin.model.Type',
    pageSize: 10,
    autoSync : true,
    autoLoad: true,
    proxy: {
        type: 'rest',
        headers: {'Content-Type': "application/json;charset=utf-8" },
        url: '/svc/types',
        startParam : '',
        pageParam : '',
        limitParam : '',
        reader: {
            type: 'json',
            root :'documentTypes'
        }
    }
});