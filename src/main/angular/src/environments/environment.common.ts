export const environment = {
    production: false,
    mapTitle: window['env']['mapTitle'] ||
          'POI Map Visualizer (Backstage Workshop RH Summit 23 Edition)',
    mapAttribution: window['env']['mapAttribution'] || 
          'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
          '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
          'Imagery &copy; <a href="http://mapbox.com">Mapbox</a>',
    mapUrl: window['env']['mapUrl'] || 
          'https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}',
    mapToken: window['env']['mapToken'] || 
          'pk.eyJ1IjoiZ3JhaGFtZHVtcGxldG9uIiwiYSI6ImNpemR6cnFhbTF0YWszMnA5eTJ0dXY1ZW8ifQ.-91_VlsyyskWAWF54GYFMg',
  //---------------------------------------------------------------------
  //TODO 1:
  //  Add the secure https route URL pointing to your proxy service into the setting below.
  //  You can find the route URL in RHDH by inspecting the component's details in the topology view.
  //  If you used the suggested namespace ('demo01') and component id ('poi-map') it should look like this https://demo01-poi-map-demo01.<cluster_id_here>
  //  Beware that this must be a secure HTTP URL that start with 'https://'
  gatewayApiUrl: window['env']['gatewayApiUrl'] || 
           '<HTTPS_ROUTE_URL_TO_YOUR_PROXY_SERVICE_HERE>',
  //TODO 2:
  //  Add the secure websocket route URL pointing to your proxy service into the setting below.
  //  You can find the route URL in RHDH by inspecting the component's details in the topology view.
  //  If you used the suggested namespace ('demo01') and component id ('poi-map') it should look like this wss://demo01-poi-map-demo01.<cluster_id_here>/ws-server-endpoint
  //  Beware that this must be a secure websocket URL that start with 'wss://'
  websocketEndpoint: window['env']['websocketEndpoint'] || 
           '<WSS_ROUTE_URL_TO_YOUR_PROXY_SERVICE_HERE>/ws-server-endpoint'
  //---------------------------------------------------------------------
};
  