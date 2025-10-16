from mininet.log import setLogLevel, info
from mininet.cli import CLI
from mininet.topo import Topo
from mininet.net import Mininet
from mininet.node import RemoteController

class HospitalTopo(Topo):

    def __init__(self, **opts):
        super(HospitalTopo, self).__init__(**opts)
        of_protocols = 'OpenFlow13'

        # Add Backbone Switch
        backbone = self.addSwitch('s1', dpid="0000000000000001", failMode='secure', protocols=of_protocols)

        # Add Department IT
        it_switch = self.addSwitch('s2', dpid="0000000000000002", failMode='secure', protocols=of_protocols)
        it_hosts = [self.addHost(f'itH{i}') for i in range(0, 5)]
        for host in it_hosts:
            self.addLink(host, it_switch)
        self.addLink(it_switch, backbone)

        # Add Department HR
        hr_switch = self.addSwitch('s3', dpid="0000000000000003", failMode='secure', protocols=of_protocols)
        hr_hosts = [self.addHost(f'hrH{i}') for i in range(0, 5)]
        for host in hr_hosts:
            self.addLink(host, hr_switch)
        self.addLink(hr_switch, backbone)

        # Add Department Finance
        finance_switch = self.addSwitch('s4', dpid="0000000000000004", failMode='secure', protocols=of_protocols)
        finance_hosts = [self.addHost(f'finH{i}') for i in range(0, 3)]
        for host in finance_hosts:
            self.addLink(host, finance_switch)
        self.addLink(finance_switch, backbone)

        # Add Department Marketing
        marketing_switch = self.addSwitch('s5', dpid="0000000000000005", failMode='secure', protocols=of_protocols)
        marketing_hosts = [self.addHost(f'mktH{i}') for i in range(0, 6)]
        for host in marketing_hosts:
            self.addLink(host, marketing_switch)
        self.addLink(marketing_switch, backbone)

        # Shared services hosts
        web_srv = self.addHost('wSrv', ip='192.168.1.1/24')
        self.addLink(web_srv, backbone)

        dns_srv = self.addHost('dSrv', ip='192.168.1.2/24')
        self.addLink(dns_srv, backbone)

        attaquant = self.addHost('att', ip='192.168.1.3/24')
        self.addLink(attaquant, backbone)


def run():
    setLogLevel('info')

    # ONOS controller ip address
    controller_ip = 'localhost'

    net = Mininet(
        topo=HospitalTopo(),
        controller=RemoteController('c', ip=controller_ip, port=6653),
        ipBase='192.168.1.10/24'
    )

    net.start()

    CLI(net)
    net.stop()


if __name__ == '__main__':
    run()
