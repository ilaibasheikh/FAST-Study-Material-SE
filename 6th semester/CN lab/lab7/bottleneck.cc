#include "ns3/core-module.h"
#include "ns3/network-module.h"
#include "ns3/internet-module.h"
#include "ns3/point-to-point-module.h"
#include "ns3/applications-module.h"
#include "ns3/flow-monitor-module.h"

using namespace ns3;

NS_LOG_COMPONENT_DEFINE ("BottleneckAnalysisExample");

void RunSimulation (uint32_t trafficRate)
{
  std::cout << "\nRunning Simulation for Traffic Rate = " << trafficRate << " Mbps...\n";

  NodeContainer senders, receivers, routers;
  senders.Create (4);
  receivers.Create (4);
  routers.Create (2);

  PointToPointHelper p2p;
  p2p.SetDeviceAttribute ("DataRate", StringValue ("5Mbps"));
  p2p.SetChannelAttribute ("Delay", StringValue ("2ms"));

  NetDeviceContainer devices1 = p2p.Install (senders.Get (0), routers.Get (0));
  NetDeviceContainer devices2 = p2p.Install (senders.Get (1), routers.Get (0));
  NetDeviceContainer devices3 = p2p.Install (senders.Get (2), routers.Get (1));
  NetDeviceContainer devices4 = p2p.Install (senders.Get (3), routers.Get (1));

  // Bottleneck link 
  PointToPointHelper bottleneck;
  bottleneck.SetDeviceAttribute ("DataRate", StringValue ("1Mbps"));
  bottleneck.SetChannelAttribute ("Delay", StringValue ("10ms"));

  NetDeviceContainer routerDevices = bottleneck.Install (routers.Get (0), routers.Get (1));

  NetDeviceContainer devices5 = p2p.Install (routers.Get (0), receivers.Get (0));
  NetDeviceContainer devices6 = p2p.Install (routers.Get (0), receivers.Get (1));
  NetDeviceContainer devices7 = p2p.Install (routers.Get (1), receivers.Get (2));
  NetDeviceContainer devices8 = p2p.Install (routers.Get (1), receivers.Get (3));

  InternetStackHelper stack;
  stack.Install (senders);
  stack.Install (receivers);
  stack.Install (routers);

  // Assign IP addresses
  Ipv4AddressHelper address;
  address.SetBase ("10.1.1.0", "255.255.255.0");
  Ipv4InterfaceContainer senderInterfaces1 = address.Assign (devices1);

  address.SetBase ("10.1.2.0", "255.255.255.0");
  Ipv4InterfaceContainer senderInterfaces2 = address.Assign (devices2);

  address.SetBase ("10.1.3.0", "255.255.255.0");
  Ipv4InterfaceContainer senderInterfaces3 = address.Assign (devices3);

  address.SetBase ("10.1.4.0", "255.255.255.0");
  Ipv4InterfaceContainer senderInterfaces4 = address.Assign (devices4);

  address.SetBase ("10.1.5.0", "255.255.255.0");
  Ipv4InterfaceContainer routerInterfaces = address.Assign (routerDevices);

  address.SetBase ("10.1.6.0", "255.255.255.0");
  Ipv4InterfaceContainer receiverInterfaces1 = address.Assign (devices5);

  address.SetBase ("10.1.7.0", "255.255.255.0");
  Ipv4InterfaceContainer receiverInterfaces2 = address.Assign (devices6);

  address.SetBase ("10.1.8.0", "255.255.255.0");
  Ipv4InterfaceContainer receiverInterfaces3 = address.Assign (devices7);

  address.SetBase ("10.1.9.0", "255.255.255.0");
  Ipv4InterfaceContainer receiverInterfaces4 = address.Assign (devices8);
  
  Ipv4GlobalRoutingHelper::PopulateRoutingTables ();

  uint16_t port = 9; // UDP port

  OnOffHelper onoff1 ("ns3::UdpSocketFactory", InetSocketAddress (receiverInterfaces1.GetAddress (0), port));
  onoff1.SetConstantRate (DataRate (std::to_string (trafficRate) + "Mbps"));
  onoff1.SetAttribute ("PacketSize", UintegerValue (1024));

  OnOffHelper onoff2 ("ns3::UdpSocketFactory", InetSocketAddress (receiverInterfaces2.GetAddress (0), port));
  onoff2.SetConstantRate (DataRate (std::to_string (trafficRate) + "Mbps"));
  onoff2.SetAttribute ("PacketSize", UintegerValue (1024));

  OnOffHelper onoff3 ("ns3::UdpSocketFactory", InetSocketAddress (receiverInterfaces3.GetAddress (0), port));
  onoff3.SetConstantRate (DataRate (std::to_string (trafficRate) + "Mbps"));
  onoff3.SetAttribute ("PacketSize", UintegerValue (1024));

  OnOffHelper onoff4 ("ns3::UdpSocketFactory", InetSocketAddress (receiverInterfaces4.GetAddress (0), port));
  onoff4.SetConstantRate (DataRate (std::to_string (trafficRate) + "Mbps"));
  onoff4.SetAttribute ("PacketSize", UintegerValue (1024));

  ApplicationContainer apps;
  apps.Add (onoff1.Install (senders.Get (0)));
  apps.Add (onoff2.Install (senders.Get (1)));
  apps.Add (onoff3.Install (senders.Get (2)));
  apps.Add (onoff4.Install (senders.Get (3)));

  apps.Start (Seconds (1.0));
  apps.Stop (Seconds (5.0));


  PacketSinkHelper sink ("ns3::UdpSocketFactory", InetSocketAddress (Ipv4Address::GetAny (), port));
  ApplicationContainer sinkApps;
  sinkApps.Add (sink.Install (receivers.Get (0)));
  sinkApps.Add (sink.Install (receivers.Get (1)));
  sinkApps.Add (sink.Install (receivers.Get (2)));
  sinkApps.Add (sink.Install (receivers.Get (3)));

  sinkApps.Start (Seconds (0.0));
  sinkApps.Stop (Seconds (6.0));


  FlowMonitorHelper flowmon;
  Ptr<FlowMonitor> monitor = flowmon.InstallAll ();

  Simulator::Stop (Seconds (6.0));
  Simulator::Run ();

  monitor->CheckForLostPackets ();

  Ptr<Ipv4FlowClassifier> classifier = DynamicCast<Ipv4FlowClassifier> (flowmon.GetClassifier ());
  std::map<FlowId, FlowMonitor::FlowStats> stats = monitor->GetFlowStats ();

  if (stats.size() == 0)
  {
    std::cout << "No flows detected!" << std::endl;
  }

  for (auto it = stats.begin (); it != stats.end (); ++it)
  {
    Ipv4FlowClassifier::FiveTuple t = classifier->FindFlow (it->first);
    if (t.destinationPort == port)
    {
      double throughput = (it->second.rxBytes * 8.0) / (5.0 * 1000000.0); // Convert to Mbps
      std::cout << "Traffic Rate = " << trafficRate
                << " Mbps --> Flow from " << t.sourceAddress 
                << " to " << t.destinationAddress 
                << " --> Throughput = " << throughput
                << " Mbps" << std::endl;
    }
  }

  Simulator::Destroy ();
}

int main (int argc, char *argv[])
{
  NS_LOG_UNCOND ("Starting Bottleneck Analysis...");

  RunSimulation (1);
  RunSimulation (2);
  RunSimulation (5); 

  return 0;
}


