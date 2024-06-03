
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ItsmTroubleTicketManager from "./components/listers/ItsmTroubleTicketCards"
import ItsmTroubleTicketDetail from "./components/listers/ItsmTroubleTicketDetail"

import BpmProcessInstanceManager from "./components/listers/BpmProcessInstanceCards"
import BpmProcessInstanceDetail from "./components/listers/BpmProcessInstanceDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/itsms/troubleTickets',
                name: 'ItsmTroubleTicketManager',
                component: ItsmTroubleTicketManager
            },
            {
                path: '/itsms/troubleTickets/:id',
                name: 'ItsmTroubleTicketDetail',
                component: ItsmTroubleTicketDetail
            },

            {
                path: '/bpms/processInstances',
                name: 'BpmProcessInstanceManager',
                component: BpmProcessInstanceManager
            },
            {
                path: '/bpms/processInstances/:id',
                name: 'BpmProcessInstanceDetail',
                component: BpmProcessInstanceDetail
            },



    ]
})
