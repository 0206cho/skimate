<template>
    <component :is="layout" >
        
    </component>
</template>

<script>
import { computed } from '@vue/composition-api';
import DefaultLayout from './DefaultLayout';
import MainHomeLayOut from './MainHomeLayOut';

export default {
    name: 'TheLayout',
    components: {
        DefaultLayout,
        MainHomeLayOut,
    },
    setup(props, { root }){
        const layout = computed(() => root.$route.meta.layout || 'DefaultLayout' );

        return {
            layout,
        }
    }
}
</script>